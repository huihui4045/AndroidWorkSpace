package com.huihui.demo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CActivity extends BaseActivity {

    private static Context mContext;

    private static TextView mTextView;
    private Button mButton;
    private ObjectAnimator animator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        mContext = this;
        mTextView = new TextView(this);
        mButton = ((Button) findViewById(R.id.btn_c));
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CActivity.this, BActivity.class);

                startActivity(intent);
            }
        });
         animator=ObjectAnimator.ofFloat(mButton,"rotation",0,360).setDuration(2000);

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (animator!=null){
           // animator.cancel();
        }
    }
}

