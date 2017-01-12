package com.huihi.page;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;

import com.huihi.Data;
import com.huihi.R;
import com.huihi.listener.OnScrollStateListener;
import com.huihi.view.ArcView;
import com.huihi.view.ScrollHideListView;
import com.huihi.view.XListView;

import java.util.ArrayList;
import java.util.List;

public class ArcChartActivity extends AppCompatActivity implements OnScrollStateListener {

    private ArcView mCircleView;
    private XListView mListView;
    private ScrollHideListView mScrollHideView;
    private Toolbar mToolBar;


    private ObjectAnimator mAnimator;
    private boolean mShow = true;
    private ScrollView mScrollView;

    private View mTopLayout;

    private int lastY;
    private String TAG=this.getClass().getSimpleName();


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

            case Data.FLAG_MY_LIST_HIDE:

                setTheme(R.style.AppTheme_NoActionBar);


                setContentView(R.layout.list_view_hide);


                mScrollHideView = ((ScrollHideListView) findViewById(R.id.hide_list_view));

                mToolBar = ((Toolbar) findViewById(R.id.toolbar));

                mScrollHideView.setOnScrollStateListener(this);

                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(ArcChartActivity.this, android.R.layout.simple_list_item_1, getDatas(20));


                mScrollHideView.setAdapter(adapter1);

                break;

            case Data.FLAG_SCROLL_VIEW:



                setContentView(R.layout.scroll_pull_view);

                mScrollView = ((ScrollView) findViewById(R.id.scroll_view));

                mTopLayout = ((View) findViewById(R.id.ly_top));

                mScrollView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {


                        int y = (int) event.getY();

                        switch (event.getAction()){

                            case MotionEvent.ACTION_DOWN:

                                // 记录触摸点坐标

                                lastY = y;

                                break;

                            case MotionEvent.ACTION_MOVE:



                                int offsetY = y - lastY;

                                Log.e(TAG,"偏移量："+offsetY);

                                mTopLayout.offsetTopAndBottom(offsetY);

                                lastY = y;


                                break;
                            case MotionEvent.ACTION_UP:



                                break;
                        }



                        return false;
                    }
                });


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

    @Override
    public void scrollDown() {

        if (!mShow) {
            toolbarAnim(!mShow);

            mShow = !mShow;
        }
    }

    @Override
    public void scrollUp() {


        if (mShow) {

            toolbarAnim(!mShow);

            mShow = !mShow;
        }
    }

    /**
     * 是否向下滑动
     *
     * @param isShow
     */
    private void toolbarAnim(boolean isShow) {

        if (mAnimator != null && mAnimator.isRunning()) {

            mAnimator.cancel();
        }

        if (isShow) {


            mAnimator = ObjectAnimator.ofFloat(mToolBar, "translationY", mToolBar.getTranslationY(), 0);
            //mAnimator=ObjectAnimator.ofFloat(mToolBar,"alpha",1f,0f);


        } else {

            mAnimator = ObjectAnimator.ofFloat(mToolBar, "translationY", mToolBar.getTranslationY(), -mToolBar.getHeight());
            //mAnimator=ObjectAnimator.ofFloat(mToolBar,"alpha",0f,1f);
        }

        // mAnimator.setDuration(500);
        mAnimator.start();
    }
}
