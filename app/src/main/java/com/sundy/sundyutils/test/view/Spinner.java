package com.sundy.sundyutils.test.view;

import android.content.Context;
import android.util.AttributeSet;

import com.sundy.sundyutils.view.spinner.CommonSpinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundi on 2016/11/17.
 */
public class Spinner extends CommonSpinner<String> {
    public Spinner(Context paramContext) {
        super(paramContext);
    }

    public Spinner(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public Spinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    @Override
    protected List loadData() {

        ArrayList list = new ArrayList();
        list.add("飒飒看见对方");
        list.add("埃里克打开三分");
        list.add("卡萨丁阔府率饭");
        list.add("大撒发顺丰");
        return list;
    }

    @Override
    public String getSelectedData() {
        return null;
    }
}
