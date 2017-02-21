package com.huihui.demo;

import android.content.Context;

/**
 * Created by gavin on 2017/2/20.
 */

public class BaseHelper {

    private Context context;

    private static BaseHelper instance;

    public BaseHelper(Context context) {
        this.context = context;
    }

    public static BaseHelper getInstance(Context context) {
        if (instance != null) {
            instance = new BaseHelper(context);
        }
        return instance;
    }
}
