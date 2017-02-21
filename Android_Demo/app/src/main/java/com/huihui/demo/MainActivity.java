package com.huihui.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.huihui.demo.activity.WebActivity;

import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivity extends BaseActivity {
    private CopyOnWriteArrayList<String> datas = new CopyOnWriteArrayList<>();
    private static int value = 10;
    private TextView mValue;
    private Handler mHandler = new MyHandler(this);

    private static class MyHandler extends Handler {
        public WeakReference<MainActivity> mainActivity;

        public MyHandler(MainActivity mainActivity) {
            this.mainActivity = new WeakReference<>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MainActivity mainActivity = this.mainActivity.get();
            if (mainActivity != null) {
                // TODO: 2017/2/20
            }
        }
    }

    /**
     * 使用静态的内部类，不会持有当前对象的引用
     */
    private static final Runnable sRunnable = new Runnable() {
        @Override
        public void run() {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler.postDelayed(sRunnable, 600000);


        findViewById(R.id.btn_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, BActivity.class));

            }
        });

        findViewById(R.id.btn_web).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WebActivity.class));
            }
        });

        mValue = ((TextView) findViewById(R.id.tv_value));
        mValue.setText(String.valueOf(value));

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 100;

                mValue.setText(String.valueOf(value));
            }
        });


        //handler.sendEmptyMessage(11);

        Uri uri = Uri.parse("content://com.huihui.demo.BookProvider");

        getContentResolver().query(uri, null, null, null, null);
        getContentResolver().query(uri, null, null, null, null);
        getContentResolver().query(uri, null, null, null, null);


        //((ViewStub) findViewById(R.id.view_stub)).setVisibility(View.VISIBLE);
        View inflate = ((ViewStub) findViewById(R.id.view_stub)).inflate();


    }

}
