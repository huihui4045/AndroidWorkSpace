package com.huihui.recycler.touch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainFragment.OnListItemClickListener {


    private RecyclerView mRecyclerView;
    private ItemTouchHelper itemTouchHelper;
    private int dragFlags, swipeFlags;
    private List<String> mDatas = new ArrayList<>();
    private NormalRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            MainFragment fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, fragment)
                    .commit();
        }
    }

    @Override
    public void onListItemClick(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new RecyclerListFragment();
                break;

            case 1:
                //  fragment = new RecyclerGridFragment();
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .addToBackStack(null)
                .commit();
    }

}


    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview

        String str[] = getResources().getStringArray(R.array.titles);
        for (int i = 0; i < str.length; i++) {
            mDatas.add(str[i]);
        }

        adapter = new NormalRecyclerViewAdapter(this, mDatas);
        mRecyclerView.setAdapter(adapter);

        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {


            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

                if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    dragFlags = ItemTouchHelper.UP |
                            ItemTouchHelper.DOWN |
                            ItemTouchHelper.LEFT |
                            ItemTouchHelper.RIGHT;
                    swipeFlags = 0;

                    return makeMovementFlags(dragFlags, swipeFlags);
                } else {
                    dragFlags = ItemTouchHelper.UP |
                            ItemTouchHelper.DOWN;
                    int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                    return makeMovementFlags(dragFlags, swipeFlags);
                }


                //return makeMovementFlags(dragFlags,swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(mDatas, i, i + 1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        Collections.swap(mDatas, i, i - 1);
                    }
                }
                adapter.notifyItemMoved(fromPosition, toPosition);
                return true;
            }

            *//**
 * 滑动删除
 *
 * @param viewHolder
 * @param direction
 *//*
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int adapterPosition = viewHolder.getAdapterPosition();
                mDatas.remove(adapterPosition);
                adapter.notifyItemRemoved(adapterPosition);

            }

            @Override
            public boolean isItemViewSwipeEnabled() {
                return true;
            }

            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                    viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
                }
                super.onSelectedChanged(viewHolder, actionState);
            }

            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundColor(0);
            }

            @Override
            public boolean isLongPressDragEnabled() {
                //return super.isLongPressDragEnabled();
                return true;
            }
        });
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }*/

