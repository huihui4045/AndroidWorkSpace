package com.huihi.page;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.huihi.Data;
import com.huihi.R;
import com.huihi.view.ArcView;
import com.huihi.view.XListView;

import java.util.ArrayList;
import java.util.List;

public class ArcChartActivity extends AppCompatActivity {

    private ArcView mCircleView;
    private XListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        switch (getIntent().getIntExtra(Data.ARG_TYPE, 0)) {

            case Data.FLAG_ARC_VIEW:

                setContentView(R.layout.activity_pie_chart);

                mCircleView = ((ArcView) findViewById(R.id.view_chart));

                mCircleView.setSwapValue(25);

                break;

            case Data.FLAG_MY_SCROLL_VIEW:

                setContentView(R.layout.myscrollview);

                break;

            case Data.FLAG_MY_LIST_VIEW:
                setContentView(R.layout.xlist_view);


                mListView = ((XListView) findViewById(R.id.list_view));


                ArrayAdapter<String> adapter = new ArrayAdapter<>(ArcChartActivity.this, android.R.layout.simple_list_item_1, getDatas(20));


                mListView.setAdapter(adapter);


                break;
        }


    }


    private List<String> getDatas(int num) {


        ArrayList<String> datas = new ArrayList<>();


        for (int i = 0; i < num; i++) {

            datas.add(String.format("%d", i));
        }


        return datas;

    }
}
