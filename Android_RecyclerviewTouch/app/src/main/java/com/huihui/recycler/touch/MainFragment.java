package com.huihui.recycler.touch;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends ListFragment {


    public interface OnListItemClickListener {
        void onListItemClick(int position);
    }

    private OnListItemClickListener mItemClickListener;

    public MainFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mItemClickListener = (OnListItemClickListener) context;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final String[] items = getResources().getStringArray(R.array.item);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mItemClickListener.onListItemClick(position);
    }

}
