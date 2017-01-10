package com.huihi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by gavin on 2017/1/10.
 */

public class ArcView extends View {


    private Paint mArcPaint, mCirclePaint, mTextPaint, mPaint;

    private float length;

    private float mRadius;

    private float mCircleXY;

    private float mSweepValue = 0;

    private String mShowText = "0%";

    private RectF mRectF;

    private int mMeasureHeigth;
    private int mMeasureWidth;


    public ArcView(Context context) {
        super(context);

    }

    public ArcView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    private void initView() {
        mArcPaint = new Paint();
        mArcPaint.setStrokeWidth(50);
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(Color.GREEN);
        mArcPaint.setStyle(Paint.Style.FILL);


        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.RED);
        mCirclePaint.setAntiAlias(true);
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.RED);
        mTextPaint.setStrokeWidth(0);
        mTextPaint.setTextSize(30);

        mPaint = new Paint();
        mPaint.setStrokeWidth(50);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.FILL);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeigth = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mMeasureWidth, mMeasureHeigth);
        initView();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        length = w;

        mCircleXY = length / 2;

        mRadius = (float) (length * 0.5 / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制狐  首先要绘制外接矩形
        mRectF = new RectF(((float) (length * 0.2)), ((float) (length * 0.2)), ((float) (length * 0.8)), ((float) (length * 0.8)));

        canvas.drawArc(mRectF, 90, 270, true, mArcPaint);

        // 画弧线
        canvas.drawArc(mRectF, 0, 90, true, mPaint);



        //  canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);

        // 绘制文字
        float textWidth = mTextPaint.measureText(mShowText);   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间




        canvas.drawText(mShowText, (int)(length/2-textWidth/2), (int)(length/2+30/2), mTextPaint);
    }

    public void setSwapValue(float mSweepValue){

        float a = (float) mSweepValue;
        if (a != 0) {
            this.mSweepValue = (float) (360.0 * (a / 100.0));
            mShowText = mSweepValue + "%";
            Log.e("this.mSweepValue:", this.mSweepValue + "");
        } else {
            this.mSweepValue = 25;
            mShowText = 25 + "%";
        }

        invalidate();
    }
}
