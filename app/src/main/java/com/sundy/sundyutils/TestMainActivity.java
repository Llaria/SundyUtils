package com.sundy.sundyutils;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestMainActivity extends AppCompatActivity {

    @Bind(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
//        if (Build.VERSION.SDK_INT >= 21){
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//        }

        if (Build.VERSION.SDK_INT >=19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @OnClick(R.id.button)
    public void onClick() {

    }
}
