package com.huihi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by gavin on 2016/12/29.
 */

public class BesselCurveView extends View {

    private float mSupX;

    private  float mSupY;


    public BesselCurveView(Context context) {
        super(context);
    }

    public BesselCurveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BesselCurveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        Path path = new Path();
        path.moveTo(300, 300);
        path.quadTo(mSupX, mSupY, 400, 200);
        canvas.drawPath(path, p);

        canvas.drawPoint(mSupX,mSupY,p);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                mSupX = event.getX();
                mSupY = event.getY();
                invalidate();
        }
        return true;
    }
}
