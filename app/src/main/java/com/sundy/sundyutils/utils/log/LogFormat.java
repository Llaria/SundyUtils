package com.sundy.sundyutils.utils.log;

/**
 * 格式化输出日志
 * Created by sundi on 2016/11/16.
 */
public interface LogFormat {

    /**
     * 格式化控制台输出
     * @param logInfo
     * @return
     */
    String formatConsole(LogInfo logInfo);

    /**
     * 格式化输出，普通文本或是XML
     * @param logInfo
     * @return
     */
    String formatOutput(LogInfo logInfo);
}
