package com.huihi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;

import com.huihi.R;
import com.huihi.listener.OnScrollStateListener;

/**
 * Created by gavin on 2017/1/11.
 */

public class ScrollHideListView extends ListView {

    private float mFirstY;

    private float mCurrentY;
    private int mTouchStop;


    public ScrollHideListView(Context context) {
        super(context);

        initView(context);
    }


    public ScrollHideListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView(context);
    }

    public ScrollHideListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {

        View header = new View(context);
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(
                        R.dimen.abc_action_bar_default_height_material)));

        addHeaderView(header);


        mTouchStop = ViewConfiguration.get(context).getScaledTouchSlop();


    }


    private OnScrollStateListener listener;

    public void setOnScrollStateListener(OnScrollStateListener listener) {

        this.listener = listener;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:

                mFirstY = ev.getY();

                break;

            case MotionEvent.ACTION_MOVE:

                mCurrentY = ev.getY();

                if (mCurrentY - mFirstY > mTouchStop) {

                    if (listener != null) {

                        listener.scrollDown();
                    }

                } else if (mFirstY - mCurrentY > mTouchStop) {

                    if (listener != null) {

                        listener.scrollUp();
                    }
                }


                break;

            case MotionEvent.ACTION_UP:
                break;


        }


        return super.onTouchEvent(ev);
    }
}
