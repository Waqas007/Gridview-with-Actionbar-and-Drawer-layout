package com.example.waqas.testq;

/**
 * Created by Waqas on 6/21/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import Fragments.DetailedFragment;
import Fragments.GridviewFragment;

/**
 * Created by Waqas on 6/11/2015.
 */
public class DbOpenHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME_MOVIES = "Movies";
    public static final String TABLE_NAME_QUOTES = "Quotes";
    private static final String TAG = "SqLite open helper";
    public Context mcontext;
    private static SQLiteDatabase msqlDatabase;
    TextView textView;
    DbOpenHelper db;

    public DbOpenHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
        this.mcontext =context;
    }




    public void createDatabase(){
        boolean dbExists = isDbExists();
        if(dbExists){
            //do nothing
            Log.i(TAG, "Database  exists");
        }else{
            Log.i(TAG, "Database donot exists");
            this.getWritableDatabase();
            copyDatabase();
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

    public void openDatabase(){
        String path = Constants.DB_PATH+Constants.DB_NAME;
        try{
            msqlDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
            Log.e(TAG, "database Opened");
        }
        catch(Exception e){
            e.printStackTrace();
            Log.e(TAG, "Could not open databse");
        }
    }
    public void closeDatabase(){
        msqlDatabase.close();
    }

    //check if database exists
    private boolean isDbExists(){
        File dbFile = new File(Constants.DB_PATH + Constants.DB_NAME);
        return dbFile.exists();
    }

    //copy database file to application database location
    public void copyDatabase(){
        try {
            InputStream inputstream = mcontext.getAssets().open(Constants.DB_NAME);
            OutputStream outputStream = new FileOutputStream(Constants.DB_PATH+Constants.DB_NAME);
            int length;
            byte[] buffer = new byte[1024];
            while((length = inputstream.read(buffer)) > 0){
                outputStream.write(buffer,0,length);

                Log.i("copydatabase","copydatabase");
            }
            outputStream.flush();
            inputstream.close();
            outputStream.close();

            Log.i("copydatabase", "copy");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    // Add your public helper methods to access and get content from the database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
    // to you to create adapters for your views.

    // Getting All Contacts
    public List<Constants> getAllContacts() {
        List<Constants> contactList = new ArrayList<Constants>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME_QUOTES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Constants contact = new Constants();

                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setMid(Integer.parseInt(cursor.getString(1)));
                contact.setQuote(cursor.getString(2));
                // contact.setImg(cursor.getString(2));
                //contact.setId(Integer.parseInt(cursor.getString(3)));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }




    // Getting single contact
    public Constants getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME_MOVIES, new String[]{Constants.COLUMN_ID,
                        Constants.COLUMN_MOVIE, Constants.COLUMN_YEAR, Constants.COLUMN_IMG_REF}, Constants.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Constants contact = new Constants(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3));
        // return contact
        return contact;
    }



    public Constants readSingleRecord(int Id) {

        Constants objectConstant = null;

        String sql = "SELECT * FROM Movies where id="+1;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String year = cursor.getString(cursor.getColumnIndex("Year"));
            String img = cursor.getString(cursor.getColumnIndex("Img_Ref"));


            objectConstant = new Constants();
            objectConstant.id = id;
            objectConstant.movie = name;
            objectConstant.year = year;
            objectConstant.img = img;

        }

        cursor.close();
        db.close();

        return objectConstant;

    }



}


