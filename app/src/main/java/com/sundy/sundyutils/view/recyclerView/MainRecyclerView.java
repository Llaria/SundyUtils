package com.sundy.sundyutils.view.recyclerView;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.sundy.sundyutils.adapter.baseAdapter.AbsRecyclerViewAdapter;
import com.sundy.sundyutils.view.recyclerView.settingsList.RecyclerItemEntity;

import java.util.List;

/**
 * Created by sundi on 2016/11/17.
 */
public class MainRecyclerView extends AbsRecyclerViewAdapter<RecyclerItemEntity> {

    public MainRecyclerView(@NonNull List<RecyclerItemEntity> items, @LayoutRes int itemLayout) {
        super(items, itemLayout);
    }

    @Override
    protected void convert(RecyclerViewHolder holder, RecyclerItemEntity item, int position) {

    }
}
