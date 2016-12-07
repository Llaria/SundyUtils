package com.sundy.sundyutils.view.recyclerView.settingsList;

import android.view.View;

/**
 * 主界面选项通用实体
 */
public class RecyclerItemEntity {

    int imageRes;
    String label;
    String labelNum = "";
    public View.OnClickListener itemClick;

    public RecyclerItemEntity(String label, int imageRes, View.OnClickListener itemClick, String num) {
        this.imageRes = imageRes;
        this.label = label;
        this.labelNum = num;
        this.itemClick = itemClick;
    }

    public RecyclerItemEntity(String label, int imageRes, View.OnClickListener itemClick) {
        this.imageRes = imageRes;
        this.label = label;
        this.itemClick = itemClick;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public View.OnClickListener getItemClick() {
        return itemClick;
    }

    public void setItemClick(View.OnClickListener itemClick) {
        this.itemClick = itemClick;
    }

    public String getLabelNum() {
        return labelNum;
    }

    public void setLabelNum(String labelNum) {
        this.labelNum = labelNum;
    }
}
