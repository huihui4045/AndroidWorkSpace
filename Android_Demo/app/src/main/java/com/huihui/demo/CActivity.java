package com.huihui.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);


        findViewById(R.id.btn_c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CActivity.this, BActivity.class);

                startActivity(intent);
            }
        });
    }
}
