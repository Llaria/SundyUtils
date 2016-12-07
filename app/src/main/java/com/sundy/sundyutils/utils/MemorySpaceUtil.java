package com.sundy.sundyutils.utils;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * 存储空间检查工具类
 * Created by sundi on 2016/11/16.
 */
public class MemorySpaceUtil {
    private static MemorySpaceUtil memorySpaceCheck;

    private MemorySpaceUtil() {
    }

    public static MemorySpaceUtil getInstance() {
        if(memorySpaceCheck == null) {
            memorySpaceCheck = new MemorySpaceUtil();
        }

        return memorySpaceCheck;
    }

    private long getAvailableSize(String path) {
        StatFs fileStats = new StatFs(path);
        fileStats.restat(path);
        return (long)fileStats.getAvailableBlocks() * (long)fileStats.getBlockSize();
    }

    private long getTotalSize(String path) {
        StatFs fileStats = new StatFs(path);
        fileStats.restat(path);
        return (long)fileStats.getBlockCount() * (long)fileStats.getBlockSize();
    }

    public long getSDAvailableSize() {
        return Environment.getExternalStorageState().equals("mounted")?this.getAvailableSize(Environment.getExternalStorageDirectory().toString()):0L;
    }

    public long getSystemAvailableSize() {
        return this.getAvailableSize("/data");
    }

    public boolean hasEnoughMemory(String filePath) {
        File file = new File(filePath);
        long length = file.length();
        return !filePath.startsWith("/sdcard") && !filePath.startsWith("/mnt/sdcard")?this.getSystemAvailableSize() > length:this.getSDAvailableSize() > length;
    }

    public long getSDTotalSize() {
        return Environment.getExternalStorageState().equals("mounted")?this.getTotalSize(Environment.getExternalStorageDirectory().toString()):0L;
    }

    public long getSysTotalSize() {
        return this.getTotalSize("/data");
    }
}
