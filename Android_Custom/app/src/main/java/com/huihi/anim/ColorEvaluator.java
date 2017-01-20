package com.huihi.anim;

import android.animation.TypeEvaluator;

/**
 * Created by gavin on 2017/1/20.
 * 自定义属性动画之颜色变化
 */

public class ColorEvaluator implements TypeEvaluator {
    private int mCurrentRed = -1;

    private int mCurrentGreen = -1;

    private int mCurrentBlue = -1;
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {


        String startColor = (String) startValue;
        String endColor = (String) endValue;

      /*  int startRed = Integer.parseInt(startColor.substring(1, 3), 16);
        int startGreen = Integer.parseInt(startColor.substring(3, 5), 16);
        int startBlue = Integer.parseInt(startColor.substring(5, 7), 16);
        int endRed = Integer.parseInt(endColor.substring(1, 3), 16);
        int endGreen = Integer.parseInt(endColor.substring(3, 5), 16);
        int endBlue = Integer.parseInt(endColor.substring(5, 7), 16);*/


        //int startRed=Integer.parseInt()



        return null;
    }
}
