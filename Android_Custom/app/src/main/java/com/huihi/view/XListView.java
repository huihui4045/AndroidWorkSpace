package com.huihi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by gavin on 2017/1/11.
 */

public class XListView extends ListView implements  AbsListView.OnScrollListener {

    private static int mMaxOverDistance=80;
    public XListView(Context context) {
        super(context);

        initView(context);
    }



    public XListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView(context);
    }

    public XListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }


    private void initView(Context context) {

        setOnScrollListener(this);
        DisplayMetrics measure=context.getResources().getDisplayMetrics();

        float density = measure.density;

        Log.e("XListView","density:"+density);

        mMaxOverDistance= (int) (density*mMaxOverDistance);
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }


    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY,
                                   int scrollRangeX, int scrollRangeY, int maxOverScrollX,
                                   int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY,

                maxOverScrollX, mMaxOverDistance, isTouchEvent);
    }
}
