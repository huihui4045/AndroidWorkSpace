package com.huihi.anim;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by gavin on 2017/1/20.
 * 自定义动画
 */

public class CustomAnimation extends Animation {

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        Matrix matrix = t.getMatrix();

        //通过matrix 各种操作实现动画

    }
}
