package com.sundy.sundyutils.utils.log;

import android.util.Log;

import com.sundy.sundyutils.preference.SundyPreference;
import com.sundy.sundyutils.utils.DateUtil;
import com.sundy.sundyutils.utils.FileUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.sundy.sundyutils.utils.FileUtil.SDPATH;
import static com.sundy.sundyutils.utils.FileUtil.SEP;

/**
 * 日志管理类
 * Created by sundi on 2016/11/16.
 */
public class LogManager {

    private static final LogManager instance = new LogManager();
    public LogConfig config;
    public LogFormat format;
    private int logAutoClearDay = 10;

    private LogManager(){
        config = new LogConfig();
        format = new SimpleLogFormat();
        logAutoClearDay = SundyPreference.getInstance().getLogAutoClearDays();
    }

    /**
     * 单例模式返回唯一对象
     * @return
     */
    public static LogManager getInstance(){
        return instance;
    }

    public void initLogConfig(LogConfig config) {
        this.config = config;
    }

    public void initLogConfig(String tag, String customer) {
        this.config = new LogConfig(tag, customer);
    }

    public void setDebug(boolean isDebug) {
        this.config.isDebug = isDebug;
    }

    public void setLogFormat(LogFormat format) {
        this.format = format;
    }

    public void info(LogInfo data) {
        Log.i(data.getTag(), format.formatConsole(data));
    }

    public void debug(LogInfo data) {
        Log.d(data.getTag(), format.formatConsole(data));
        if (config.isDebug)
            write(format.formatOutput(data));
    }

    public void error(LogInfo data) {
        Log.e(data.getTag(), format.formatConsole(data));
        write(format.formatOutput(data));
    }

    public synchronized void write(final String content) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(config.fileDir);
            sb.append(SEP);
            sb.append(DateUtil.getDateFormat(new Date()));
            sb.append(".log");
            String file = sb.toString();
        	/*int mb = 200 * 1024;
        	if (FileUtil.getFileSize(file) > mb) {
        	}*/
            FileUtil.writeFileByNio(file, content, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized String read(String path) {
        try {
            return FileUtil.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getFileList() {
        return getFileList(config.fileDir);
    }

    /**
     * 文件名倒叙排列
     * @param dir
     * @return
     */
    public List<String> getFileList(String dir) {
        List<String> fileList = FileUtil.getFileNameList(dir, "log");
        Collections.sort(fileList);
        Collections.reverse(fileList);
        return fileList;
    }

    public boolean delete(String fileName) {
        return FileUtil.deleteFile(config.fileDir + SEP + fileName);
    }

    public boolean deleteDir() {
        return FileUtil.deleteFile(config.fileDir);
    }

    /**
     * 自动清理日志
     */
    public void autoClear() {
        FileUtil.delete(config.fileDir, new FilenameFilter() {

            @Override
            public boolean accept(File file, String filename) {
                String s = FileUtil.getFileNameWithoutExtension(filename);
                int day = logAutoClearDay < 0 ? logAutoClearDay : -1 * logAutoClearDay;
                String date = DateUtil.getOtherDay(day);
                return date.compareTo(s) >= 0;
            }
        });
    }

    /**
     * 日志的配置
     */
    public static class LogConfig {

        /** 如未设置tag则采用该参数, KaicomLog */
        public static final String DEFAULT_TAG = "SundyLog";
        /** 如未设置文件路径则采用该参数, sd下KlLog/目录 */
        public static final String DEFAULT_FILE_PATH_PREFIX = SDPATH + "Sundy";
        /** 文件目录， 一般需要客户程序自己设置 */
        public String fileDir = DEFAULT_FILE_PATH_PREFIX;
        /** tag， 一般需要客户程序自己设置 */
        public String tag = DEFAULT_TAG;
        /** 该标记用来控制debug是否需要写文件，为true时会写文件，默认为true
         */
        public boolean isDebug = true;

        public LogConfig() {
        }

        /**
         * 创建LogConfig
         * @param tag 日志打印用的标签
         * @param customer 客户目录名
         */
        public LogConfig(String tag, String customer) {
            this.tag = tag;
            this.fileDir = DEFAULT_FILE_PATH_PREFIX + SEP + customer;
        }
    }
}
