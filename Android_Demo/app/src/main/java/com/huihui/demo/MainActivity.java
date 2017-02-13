package com.huihui.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class MainActivity extends BaseActivity implements Handler.Callback{

    private Handler handler=new Handler(this);

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


        handler.sendEmptyMessage(11);

    }

    @Override
    public boolean handleMessage(Message msg) {


        return false;
    }
}
