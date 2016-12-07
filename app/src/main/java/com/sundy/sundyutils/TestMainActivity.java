package com.sundy.sundyutils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sundy.sundyutils.activity.TabMovedActivity.TabMoveActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestMainActivity extends AppCompatActivity {

    @Bind(R.id.test_textView)
    TextView testTextView;
    @Bind(R.id.button)
    Button button;

    private Handler mHandler;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Looper.prepare();
                mHandler = new Handler(Looper.getMainLooper()) {
                    @Override
                    public void handleMessage(Message msg) {
                        if (msg.what == 0x13) {
                            Toast.makeText(TestMainActivity.this, "收到消息！", Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                //Looper.loop();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(TestMainActivity.this, "收到消息！", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }

    @OnClick(R.id.button)
    public void onClick() {
//        Message message1 = new Message();
//        Message message2 = Message.obtain();
        Message message3 = mHandler.obtainMessage();
//        mHandler.sendEmptyMessage(0x13);
        message3.what = 0x13;
        message3.sendToTarget();
        Intent intent = new Intent(TestMainActivity.this, TabMoveActivity.class);
        startActivity(intent);
    }
}
