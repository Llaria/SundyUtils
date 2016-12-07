package com.sundy.sundyutils;

import android.widget.TextView;

import butterknife.Bind;

public class MainActivity extends BizBaseActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.text_view)
    TextView textView;

    @Override
    protected int setContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        String s = null;
        for (int i = 0; i < 50; i++) {
            s = s + "今天天气真是好啊!";
        }
        //textView.setText(s);
    }

}


