package com.example.waqas.testq;

import android.app.Activity;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Fragments.DetailedFragment;
import Fragments.GridviewFragment;


public class MainActivity extends FragmentActivity {
    DbOpenHelper db = new DbOpenHelper(this);
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.createDatabase();
        db.openDatabase();

        GridviewFragment gf = new GridviewFragment();

        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container2, gf);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Constants> contacts = db.getAllContacts();

        for (Constants cn : contacts) {
            //  String log = "Id: " + cn.getId() + " ,Name: " + cn.getMovie() + " ,Phone: " + cn.getYear() + ",Year:" + cn.getImg();
            String log = "Id: " + cn.getId() + " ,Mid: " + cn.getMid() + " ,Quote: " + cn.getQuote();
            // Writing Contacts to log
            Log.d("Name: ", log);

        }

        Log.d("Reading: ", "Reading single contact..");
        int id = 1;
        Constants contact = db.readSingleRecord(id);

        for (Constants cn : contacts) {
            //  String log = "Id: " + cn.getId() + " ,Name: " + cn.getMovie() + " ,Phone: " + cn.getYear() + ",Year:" + cn.getImg();
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getMovie() + " ,Year: " + cn.getYear() + " ,Img: " + cn.getImg();
            // Writing Contacts to log
            Log.d("Name: ", log);

        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
