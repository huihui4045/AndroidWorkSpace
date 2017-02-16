package com.huihui.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gavin on 2017/2/15.
 */

public class XView extends View {
    public XView(Context context) {
        super(context);
    }

    public XView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
