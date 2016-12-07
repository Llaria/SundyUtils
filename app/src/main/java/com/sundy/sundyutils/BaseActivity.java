package com.sundy.sundyutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.sundy.sundyutils.utils.log.CrashHandler;
import com.sundy.sundyutils.utils.log.SundyLoger;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * 基类
 * Created by sundi on 2016/10/18.
 */
public abstract class BaseActivity extends RxAppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewID());
        baseInit();
        init();
    }

    /**
     * 初始化基类
     */
    private void baseInit() {
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        SundyLoger.autoClear();
        CrashHandler.getInstance().autoClear();
    }

    /**
     * 子类去实现，布局文件
     * @return
     */
    protected abstract int setContentViewID();

    /**
     * 子类去实现，初始化
     */
    protected abstract void init();

    /**
     * 跳转到Activity
     * @param cls
     */
    public void toNextActivity(Class cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
