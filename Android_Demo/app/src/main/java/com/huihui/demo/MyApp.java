package com.huihui.demo;

import android.app.Application;
import android.util.Log;

/**
 * Created by gavin on 2017/2/9.
 */

public class MyApp extends Application {

    private static String TAG = "MyApp";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e(TAG, "onCreate");
    }
}
