package com.huihui.recycler.touch;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by gavin on 2017/2/10.
 */

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private ItemTouchHelperListener listener;


    public SimpleItemTouchHelperCallback(ItemTouchHelperListener listener) {
        this.listener = listener;
    }

    /**
     * 指定拖动和滑动支持的方向
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // Set movement flags based on the layout manager
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            final int swipeFlags = 0;
            return makeMovementFlags(dragFlags, swipeFlags);
        } else {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
            return makeMovementFlags(dragFlags, swipeFlags);
        }
    }

    /**
     *拖动前后的位置
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return listener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
    }
    /**
     * 滑动
     *
     * @param viewHolder
     * @param direction  滑动的方向
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        listener.onItemDismiss(viewHolder.getAdapterPosition());
    }

    /**
     * 在每次View Holder的状态变成拖拽 (ACTION_STATE_DRAG) 或者 滑动 (ACTION_STATE_SWIPE)的时候被调用。
     *
     * @param viewHolder
     * @param actionState
     */
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {

        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
        }

        super.onSelectedChanged(viewHolder, actionState);
    }

    /**
     * 在一个view被拖拽然后被放开的时候被调用，
     *
     * @param recyclerView
     * @param viewHolder
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {


        super.clearView(recyclerView, viewHolder);

        viewHolder.itemView.setBackgroundColor(Color.RED);
    }

    /**
     * @return 返回true 设置  支持长按进入拖动
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    /**
     * 支持滑动
     *
     * @return
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }
}
