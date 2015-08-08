package Fragments;

import android.database.Cursor;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
//import android.app.FragmentManager;
import android.support.v4.app.*;
//import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.waqas.testq.Constants;
import com.example.waqas.testq.DbOpenHelper;
import com.example.waqas.testq.GridAdapter;
import com.example.waqas.testq.R;

/**
 * Created by Waqas on 6/16/2015.
 */
public class GridviewFragment extends Fragment {

    DbOpenHelper db = new DbOpenHelper(getActivity());

    final static String KEY_MSG_1 = "FRAGMENT1_MSG";
    public Integer[] mThumbIds = {R.drawable.darknight,
            R.drawable.goodfellas,R.drawable.hungergames2,
            R.drawable.jobs, R.drawable.startrek,
            R.drawable.thesocialnetwork};
            DetailedFragment df;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_gridview, container, false);
        GridView gridView = (GridView)view.findViewById(R.id.gridview);
        gridView.setAdapter(new GridAdapter(getActivity()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),mThumbIds[position],Toast.LENGTH_LONG).show();
                Log.i("args grid", "" + mThumbIds[position]);


                DetailedFragment df = new DetailedFragment();

                FragmentManager fragmentManager = getFragmentManager();

                Bundle args = new Bundle();

                args.putInt(DetailedFragment.ARG_POSITION,position);
                df.setArguments(args);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.hide(GridviewFragment.this);
                fragmentTransaction.replace(R.id.container2,df);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        return view;
    }
}