package com.huihui.recycler.touch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by molu_ on 2017/2/9.
 */

public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<String> mTitles;

    public NormalRecyclerViewAdapter(Context context, List<String> datas) {
        mTitles = datas;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.mTextView.setText(mTitles.get(position));
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.size();
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        private
        TextView mTextView;


        NormalTextViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.tv_name);
        }
    }
}
