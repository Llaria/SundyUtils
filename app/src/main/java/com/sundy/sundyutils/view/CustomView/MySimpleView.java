package com.sundy.sundyutils.view.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * 简单的自定义View
 * Created by sundi on 2016/11/18.
 */
public class MySimpleView extends View {

    private String myViewTitle;
    private int myViewTitleCololr;
    private int getMyViewTitleSize;

    public MySimpleView(Context context) {
        super(context);
    }

    public MySimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
