package com.example.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;


import java.util.List;

public  class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        Log.i(LOG_TAG,"I am inside onStartloading");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground(){
        Log.i(LOG_TAG,"I am inside loadinbackground");
        if(mUrl == null){
            return null;
        }
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);

        return earthquakes;
    }



}
