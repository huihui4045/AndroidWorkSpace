package com.huihi.page;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
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

import static com.huihi.R.id.view;

public class ArcChartActivity extends AppCompatActivity implements OnScrollStateListener, View.OnClickListener {

    private ArcView mCircleView;
    private XListView mListView;
    private ScrollHideListView mScrollHideView;
    private Toolbar mToolBar;


    private ObjectAnimator mAnimator;
    private boolean mShow = true;
    private ScrollView mScrollView;

    private View mTopLayout;

    private int lastY;
    private String TAG = this.getClass().getSimpleName();
    private int mFirstTop;
    private View mView;


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

                        switch (event.getAction()) {

                            case MotionEvent.ACTION_DOWN:

                                // 记录触摸点坐标

                                lastY = y;

                                break;

                            case MotionEvent.ACTION_MOVE:


                                int bottom = mTopLayout.getBottom();


                                int allOffsetY = Math.abs((bottom - mFirstTop));
                                Log.e(TAG, "总偏移量：" + allOffsetY);


                                //  if (allOffsetY<mFirstTop){

                                int offsetY = y - lastY;

                                Log.e(TAG, "偏移量：" + offsetY);


                                mTopLayout.offsetTopAndBottom(offsetY);

                                //mScrollView.offsetTopAndBottom(offsetY);


                                //}

                                lastY = y;


                                break;
                            case MotionEvent.ACTION_UP:


                                break;
                        }


                        return false;
                    }
                });


                break;

            case Data.FLAG_ANIM:

                setContentView(R.layout.anim);

                mView = findViewById(view);


                break;

            case Data.FLAG_ANIM_CUSTOM:

                setContentView(R.layout.custom_anim);

                break;
        }


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_alpha:

                startAlphaAnim(mView);

                break;

            case R.id.btn_scale:

                startScaleAnim();

                break;

            case R.id.btn_Translation:

                startTranslationAnimtor();

                break;

            case R.id.btn_Rotation:

                startRotationAnimtor();

                break;

            case R.id.btn_AnimList:

                startPropertyAnim();

                break;


        }
    }

    private void startPropertyAnim() {

        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f);
        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofFloat("Rotation", 0, 360);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mView, pvhScaleX, pvhScaleY, pvhRotation);

        animator.setDuration(2000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(-1);
        animator.start();

        ValueAnimator valueAnimator;


    }

    private AnimatorSet mAnimatorSet = new AnimatorSet();

    /**
     * 透明度
     * RESTART：重新从头开始执行。
     * REVERSE：反方向执行。
     *
     * @param view
     */
    private void startAlphaAnim(View view) {

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f);
        animator.setDuration(3000);
        animator.setRepeatCount(-1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }

    /**
     * 位移动画
     */
    private void startTranslationAnimtor() {

        ObjectAnimator animator = ObjectAnimator.ofFloat(mView, "TranslationX", 0, 500);
        animator.setDuration(3000);
        animator.setRepeatCount(-1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }

    /**
     * 缩放
     */
    private void startScaleAnim() {

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mView, "scaleX", 1f, 0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mView, "scaleY", 1f, 0f);
        ObjectAnimator animator = ObjectAnimator.ofFloat(mView, "alpha", 1f, 0f);
        scaleX.setRepeatCount(-1);
        scaleY.setRepeatCount(-1);
        animator.setRepeatCount(-1);
        scaleX.setRepeatMode(ValueAnimator.REVERSE);
        scaleY.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        mAnimatorSet.setDuration(2000);
        mAnimatorSet.setInterpolator(new DecelerateInterpolator());
        mAnimatorSet.playTogether(scaleX, scaleY, animator);//两个动画同时开始
        mAnimatorSet.start();
    }

    /**
     * 旋转动画
     */
    private void startRotationAnimtor() {

        ObjectAnimator rotation = ObjectAnimator.ofFloat(mView, "Rotation", 0, 180);
        // rotation.setRepeatCount(-1);
        rotation.setRepeatMode(ValueAnimator.REVERSE);
        rotation.setDuration(2000);
        rotation.start();



    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mTopLayout != null)
            mTopLayout.post(new Runnable() {
                @Override
                public void run() {

                    mFirstTop = mTopLayout.getHeight();
                }
            });
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
