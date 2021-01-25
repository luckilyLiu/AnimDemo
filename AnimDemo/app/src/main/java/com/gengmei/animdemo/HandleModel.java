package com.gengmei.animdemo;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public abstract class HandleModel implements IModel {
    private IView view;
    private final Handler handler = new Handler(Looper.getMainLooper());

    public void handleData(Object data) {
        if (!TextUtils.isEmpty((CharSequence)data)) {
            this.handler.removeCallbacksAndMessages((Object)null);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                }
            }, 3000);
        }
    }

    public void clearData() {
        this.handler.removeCallbacksAndMessages((Object)null);
    }
}