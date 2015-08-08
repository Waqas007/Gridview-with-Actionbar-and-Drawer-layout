package com.example.waqas.testq;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Waqas on 6/16/2015.
 */
public class GridAdapter extends BaseAdapter {


    private Context mContext;

    public GridAdapter() {
    }

    public GridAdapter(Context mContext) {
        this.mContext = mContext;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {R.drawable.darknight,
            R.drawable.goodfellas,R.drawable.hungergames2,
            R.drawable.jobs, R.drawable.startrek,
            R.drawable.thesocialnetwork};



    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {

        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {

        return mThumbIds[position];
    }

    public Integer[] getmThumbIds() {
        return mThumbIds;
    }

    public void setmThumbIds(Integer[] mThumbIds) {
        this.mThumbIds = mThumbIds;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
         //imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new GridView.LayoutParams(375, 375));
        Log.i("getView", "set adapter");
        return imageView;

    }


}
