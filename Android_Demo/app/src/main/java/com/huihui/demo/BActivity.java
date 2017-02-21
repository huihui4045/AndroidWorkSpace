package com.huihui.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BActivity extends BaseActivity {
    private static DataResource mDataResource = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        getWindow().setBackgroundDrawable(null);
        findViewById(R.id.btn_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, CActivity.class));
            }
        });

        if (mDataResource == null) {
            mDataResource = new DataResource();
        }
    }
    private class DataResource {

    }
}
