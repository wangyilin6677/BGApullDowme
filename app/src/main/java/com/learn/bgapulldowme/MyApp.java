package com.learn.bgapulldowme;

import android.app.Application;

/**
 * Created by Administrator on 2016/12/21 0021.
 */

public class MyApp extends Application {

    private static MyApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

    }

    public static MyApp getInstance(){
        return sInstance;
    }
}
