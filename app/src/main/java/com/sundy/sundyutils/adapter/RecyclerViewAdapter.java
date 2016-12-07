package com.sundy.sundyutils.adapter;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.sundy.sundyutils.R;
import com.sundy.sundyutils.adapter.baseAdapter.AbsRecyclerViewAdapter;
import com.sundy.sundyutils.test.adapterData.RecyclerViewEntity;

import java.util.List;

/**
 * RecyclerView
 * Created by sundi on 2016/11/17.
 */
public class RecyclerViewAdapter extends AbsRecyclerViewAdapter<RecyclerViewEntity> {

    public RecyclerViewAdapter(@NonNull List<RecyclerViewEntity> items) {
        super(items, R.layout.test_item_recycler_view);
    }

    @Override
    protected void convert(RecyclerViewHolder holder, RecyclerViewEntity item, int position) {
        ((TextView)(holder.getView(R.id.text))).setText(item.getNum());
    }
}
