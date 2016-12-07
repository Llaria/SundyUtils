package com.sundy.sundyutils.activity.TabMovedActivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.sundy.sundyutils.BizBaseActivity;
import com.sundy.sundyutils.R;

import java.util.ArrayList;
import java.util.List;

public class TabMoveActivity extends BizBaseActivity {

    private RecyclerView recyclerView ;
    private DragAdapter adapter;
    @Override
    protected int setContentViewID() {
        return R.layout.activity_tab_move;
    }

    @Override
    protected void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            datas.add("item" + i);
        }

        ItemDragHelperCallBack callBack = new ItemDragHelperCallBack(){
            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }

            @Override
            public boolean isItemViewSwipeEnabled() {
                return true;
            }
        };

        ItemTouchHelper helper = new ItemTouchHelper(callBack);
        helper.attachToRecyclerView(recyclerView);

        adapter = new DragAdapter(this,datas);
        recyclerView.setAdapter(adapter);
    }
}
