package com.sundy.sundyutils.view.recyclerView.settingsList;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.KeyEvent;

/**
 * 设置界面RecyclerView
 */
public class KeyRecyclerView extends RecyclerView {

    public KeyRecyclerView(Context context) {
        super(context);
    }

    public KeyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (isFastClick())
            return super.onKeyUp(keyCode, event);
        // 按键0, 表示第10项
        if (keyCode == KeyEvent.KEYCODE_0)
            keyMapping(10);
            // 按键1~9, 分别对应选项1~9
        else if (keyCode > KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9)
            keyMapping(keyCode - KeyEvent.KEYCODE_1);
        return super.onKeyUp(keyCode, event);
    }

    private static long lastClickTime;

    /**
     * 是否重复点击
     *
     * @return
     */
    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    private void keyMapping(int position) {
        if (position < 0 || position > 10 || position >= getAdapter().getItemCount())
            return;
        execute(position);
    }

    private void execute(int position) {
        ViewHolder viewHolder = this.getChildViewHolder(this.getChildAt(position));
        viewHolder.itemView.performClick();
    }
}
