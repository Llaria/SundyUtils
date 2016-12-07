package com.sundy.sundyutils;

import android.app.Application;

import com.sundy.sundyutils.utils.log.CrashHandler;
import com.sundy.sundyutils.utils.log.LogManager;

/**
 * 全局初始化
 * Created by sundi on 2016/11/16.
 */
public class MyApplication extends Application {

    public static MyApplication myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppInstance(this);
        initSetup();
    }

    /**
     *单例模式获取全局Application
     */
    public static MyApplication getInstance(){
        return myApp;
    }

    /**
     * 初始化全局设置
     */
    private void initSetup() {
        setLogInitializeArgs("SundyUtilsLog","SundyUtilsLog");
        CrashHandler.getInstance().init(this);
    }

    /**
     * 初始化全局Application
     * @param instance
     */
    private static void initAppInstance(MyApplication instance){
        myApp = instance;
    }

    /**
     * 设置日志的TAG
     * @param tag
     * @param customer
     */
    public void setLogInitializeArgs(String tag, String customer) {
        LogManager.getInstance().initLogConfig(tag, customer);
    }

}
