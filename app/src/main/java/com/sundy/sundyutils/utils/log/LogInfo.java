package com.sundy.sundyutils.utils.log;



/**
 * 包含了日志级别信息
 * Created by sundi on 2016/11/16.
 */
public class LogInfo {

    private Level level;
    private String tag;
    private String message;
    private Throwable throwableInfo;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrowableInfo() {
        return throwableInfo;
    }

    public void setThrowableInfo(Throwable throwableInfo) {
        this.throwableInfo = throwableInfo;
    }

    public boolean noThrowable() {
        return this.throwableInfo == null;
    }

    @Override
    public String toString() {
        return "LogInfo [level=" + level + ", tag=" + tag + ", message="
                + message + ", throwableInfo=" + throwableInfo + "]";
    }
}
