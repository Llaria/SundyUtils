package com.sundy.sundyutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sundy.sundyutils.utils.MD5Util;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestMainActivity extends AppCompatActivity {

    @Bind(R.id.test_textView)
    TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        ButterKnife.bind(this);

        testTextView.setText(MD5Util.getMD5Encoding("今天天气很好"));
    }
}
