package com.huihui.recycler.touch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huihui.recycler.touch.bean.User;

import java.util.Collections;
import java.util.List;

/**
 * Created by gavin on 2017/2/10.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder> implements ItemTouchHelperListener {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<User> mTitles;

    public RecyclerListAdapter(Context mContext, List<User> mTitles) {
        this.mContext = mContext;
        this.mTitles = mTitles;

        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return new ItemViewHolder(mLayoutInflater.inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        User user = mTitles.get(position);

        holder.tvAge.setText(String.valueOf(user.getAge()));

        holder.tvName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {

        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mTitles, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mTitles, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);

        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        mTitles.remove(position);
        notifyItemRemoved(position);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView tvName;
        public final TextView tvAge;

        public ItemViewHolder(View itemView) {
            super(itemView);

            tvName = ((TextView) itemView.findViewById(R.id.tvName));
            tvAge = ((TextView) itemView.findViewById(R.id.tvAge));
        }
    }
}
