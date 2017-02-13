package com.huihui.recycler.touch;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huihui.recycler.touch.bean.User;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerListFragment extends Fragment {

    private ItemTouchHelper mItemTouchHelper;


    public RecyclerListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView recyclerView = (RecyclerView) view;

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        List<User> users = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            users.add(new User("辉辉" + i, 15 + i));
        }

        RecyclerListAdapter adapter = new RecyclerListAdapter(getActivity(), users);

        recyclerView.setAdapter(adapter);


        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);

        mItemTouchHelper = new ItemTouchHelper(callback);

        mItemTouchHelper.attachToRecyclerView(recyclerView);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }
}
