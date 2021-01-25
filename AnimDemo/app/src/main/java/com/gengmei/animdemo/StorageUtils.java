package com.gengmei.animdemo;
import android.os.Environment;

import java.io.File;

public class StorageUtils {
    private final static String KEY_PIC_CACHE      = "pic";
    private final static String KEY_VOICE_CACHE    = "voice";
    private final static String KEY_DOWNLOAD_CACHE = "download";
    private static String KEY_GENGMEI_CACHE  = null;

    public static boolean isStorageAvailable = false;

    public static String PIC_CACHE      = "";
    public static String VOICE_CACHE    = "";
    public static String DOWNLOAD_CACHE = "";

    public static void init() {
        isStorageAvailable = getExternalStorageState();
        KEY_GENGMEI_CACHE = "webp文件";
        createFiles();
    }

    //创建指定文件夹和获取指定文件夹目录
    private static void createFiles() {
        PIC_CACHE = createPicDirs();
        VOICE_CACHE = createVoiceDirs();
        DOWNLOAD_CACHE = createDownloadDirs();
    }

    //获取SD卡是否可用
    public static boolean getExternalStorageState() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    private static String createPicDirs() {
        if (isStorageAvailable) {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + KEY_GENGMEI_CACHE + "/" + KEY_PIC_CACHE);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } else {
            return "";
        }
    }

    private static String createVoiceDirs() {
        if (isStorageAvailable) {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + KEY_GENGMEI_CACHE + "/" + KEY_VOICE_CACHE);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } else {
            return "";
        }
    }

    private static String createDownloadDirs() {
        if (isStorageAvailable) {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + KEY_GENGMEI_CACHE + "/" + KEY_DOWNLOAD_CACHE);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } else {
            return "";
        }
    }
}