package com.exemple.udacity_newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import androidx.annotation.Nullable;

import java.util.List;

public class News_Loader extends AsyncTaskLoader<List<News>> {
    private String mUrl;
    private static final String LOG=MainActivity.class.getSimpleName();
    public News_Loader(Context context, String url){
        super(context);
        mUrl=url;
    }
    @Nullable
    @Override
    public List<News> loadInBackground() {
        if (mUrl==null)
        {return null;}
        //Perform the network request, parse the response and extract data.
        List<News> newsList=Utils.fetchNewsData(mUrl);
        return  newsList;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}