package com.huihui.recycler.touch;

/**
 * Created by gavin on 2017/2/10.
 */

public interface ItemTouchHelperListener {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
