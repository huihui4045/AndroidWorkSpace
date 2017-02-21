package com.huihui.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivity extends BaseActivity implements Handler.Callback{

    private Handler handler=new Handler(this);

    private CopyOnWriteArrayList<String> datas=new CopyOnWriteArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, BActivity.class));

            }
        });


        //handler.sendEmptyMessage(11);

        Uri uri=Uri.parse("content://com.huihui.demo.BookProvider");

        getContentResolver().query(uri,null,null,null,null);
        getContentResolver().query(uri,null,null,null,null);
        getContentResolver().query(uri,null,null,null,null);

    }

    @Override
    public boolean handleMessage(Message msg) {


        return false;
    }
}
