package com.gengmei.animdemo;

import android.os.SystemClock;

import androidx.fragment.app.FragmentTransaction;

/**
 * 安全操作Util 。 （e.g. Fragment transaction等等）
 */
public class SafeOperateUtil {

    /**
     * see commit 方法解释
     * https://www.jianshu.com/p/f50a1d7ab161
     *
     * @param transaction
     */
    public static void commitAllowingStateLoss(FragmentTransaction transaction) {
        if (transaction == null) {
            return;
        }
        try {
            long startTime = SystemClock.uptimeMillis();
            transaction.commitAllowingStateLoss();
            long endTime = SystemClock.uptimeMillis();
        } catch (Exception e) {
        }
    }


    /**String 转 int ，安全操作，异常会返回0；
     * @param numStr
     * @return
     */
    public static int parseIntSafely(String numStr) {
        int num;
        try {
            num = Integer.parseInt(numStr);
        } catch (Exception e) {
            num = 0;
        }
        return num;
    }

    public static int parseIntSafely(String numStr, int defaultValue) {
        int num;
        try {
            num = Integer.parseInt(numStr);
        } catch (Exception e) {
            num = defaultValue;
        }
        return num;
    }

    public static long parseLongSafely(String numStr) {
        long num;
        try {
            num = Long.parseLong(numStr);
        } catch (Exception e) {
            num = 0L;
        }
        return num;
    }

    public static double parseDouble(String numStr) {
        return parseDouble(numStr, 0);
    }

    public static double parseDouble(String numStr, double defaultValue) {
        double num;
        try {
            num = Double.parseDouble(numStr);
        } catch (Exception e) {
            num = defaultValue;
        }
        return num;
    }
}
