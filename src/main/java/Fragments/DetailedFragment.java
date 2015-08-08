package Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.waqas.testq.DbOpenHelper;
import com.example.waqas.testq.GridAdapter;
import com.example.waqas.testq.R;

/**
 * Created by Waqas on 6/16/2015.
 */
public class DetailedFragment extends Fragment {
    public static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    GridAdapter imageadapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        return inflater.inflate(R.layout.layout_detailed_gridview_fragment,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("onStart", "onStart");
        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
//        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateView(args.getInt(ARG_POSITION));
            Log.i("ARG_POSITION", ARG_POSITION);
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance
            //state defined during onCreateView
            updateView(mCurrentPosition);


        }
    }

    private void updateView(int position) {
        ImageView imageView = (ImageView) getActivity().findViewById(R.id.imageview1);
       GridAdapter imageAdapter = new GridAdapter();
        imageView.setImageResource(imageAdapter.mThumbIds[position]);

        Log.i("args else", "" + position);
        Log.i("args else 2",""+imageAdapter.mThumbIds[position]);
        Toast.makeText(getActivity(), imageAdapter.mThumbIds[position], Toast.LENGTH_LONG).show();
    }



}
