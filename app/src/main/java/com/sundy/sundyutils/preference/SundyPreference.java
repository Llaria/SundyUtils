package com.sundy.sundyutils.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.sundy.sundyutils.MyApplication;

/**
 * 配置文件
 * Created by sundi on 2016/11/16.
 */
public class SundyPreference {

    private static final String FILE_NAME = "sundy_preference";
    private SharedPreferences sp;

    private SundyPreference(){
        sp = MyApplication.myApp.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    private static class SundyPreferenceHolder{
        private static final SundyPreference filePreference = new SundyPreference();
    }

    /**
     * 单例模式得到唯一对象
     */
    public static SundyPreference getInstance(){
        return SundyPreferenceHolder.filePreference;
    }

    /**
     * 设置自动清理日志的时间
     */
    public void setLogAutoClearDays(int days){
        sp.edit().putInt("log_auto_clear_days",days).apply();
    }

    /**
     * 获取自动清理日志的时间，默认为10天
     */
    public int getLogAutoClearDays(){
        return sp.getInt("log_auto_clear_days",10);
    }

    /**
     * 设置是否崩溃状态
     */
    public void setCrashStatus(boolean isCrash){
        sp.edit().putBoolean("crash",isCrash).apply();
    }

    /**
     * 获取是否崩溃状态
     */
    public boolean getCrashStatus(){
        return sp.getBoolean("crash",false);
    }

    /**
     * 设置崩溃日志自动清理时间
     */
    public void setCrashAutoClearDays(int days){
        sp.edit().putInt("crash_auto_clear_days",days).apply();
    }

    /**
     * 获取崩溃日志自动清理时间
     */
    public int getCrashAutoClearDays(){
        return sp.getInt("crash_auto_clear_days",30);
    }

    /**
     * 保存最近崩溃时间（long）
     */
    public void setLastCrashTime(long date){
        sp.edit().putLong("lastCrashTime",date).apply();
    }

    /**
     * 获取最近崩溃时间
     */
    public long getLastCrashTime(){
        return sp.getLong("lastCrashTime",0);
    }
}
