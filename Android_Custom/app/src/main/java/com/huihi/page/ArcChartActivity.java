package com.huihi.page;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.huihi.R;
import com.huihi.view.ArcView;

public class ArcChartActivity extends AppCompatActivity {

    private ArcView mCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        mCircleView = ((ArcView) findViewById(R.id.view_chart));

        mCircleView.setSwapValue(25);


    }
}
