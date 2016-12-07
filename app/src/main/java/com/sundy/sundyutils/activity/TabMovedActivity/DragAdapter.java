package com.sundy.sundyutils.activity.TabMovedActivity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sundy.sundyutils.R;

import java.util.List;

/**
 * Created by sundi on 2016/12/7.
 */

public class DragAdapter extends RecyclerView.Adapter<DragAdapter.DragViewHolder> implements OnItemMovedListener {

    private List<String> items;
    private LayoutInflater mInflater;

    public DragAdapter(Context context , List<String> items) {
        mInflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        String item = items.get(fromPosition);
        items.remove(item);
        items.add(toPosition,item);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public DragViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DragViewHolder(mInflater.inflate(R.layout.item_drag,parent,false));
    }

    @Override
    public void onBindViewHolder(DragViewHolder holder, int position) {
        holder.tv.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class DragViewHolder extends RecyclerView.ViewHolder implements OnDragVHListener {

        TextView tv;
        public DragViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }

        @Override
        public void OnItemSelected() {
            itemView.setBackgroundColor(Color.BLUE);
        }

        @Override
        public void OnItemFinish() {
            itemView.setBackgroundColor(0);
        }
    }
}
