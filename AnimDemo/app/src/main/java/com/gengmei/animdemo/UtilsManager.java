package com.gengmei.animdemo;

import android.content.Context;


/**
 * ***********************************************************************
 * Author:Michael
 * CreateData:2016-06-01 14:17
 * Version:xx
 * Description:
 * ***********************************************************************
 */
public class UtilsManager {

    private Context mContext;

    private static UtilsManager mInstance = new UtilsManager();

    public static UtilsManager getInstance() {
        return mInstance;
    }

    private UtilsManager() {
    }

    public void setApplicationContext(Context context){
        mContext = context.getApplicationContext();
        StorageUtils.init();
    }

    public Context getContext(){
        return mContext;
    }
}
