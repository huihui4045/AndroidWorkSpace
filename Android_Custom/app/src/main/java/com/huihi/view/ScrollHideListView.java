package com.huihi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.huihi.R;

/**
 * Created by gavin on 2017/1/11.
 */

public class ScrollHideListView extends ListView {


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


    }
}
