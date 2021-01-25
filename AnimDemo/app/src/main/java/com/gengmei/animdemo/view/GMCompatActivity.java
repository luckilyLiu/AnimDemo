package com.gengmei.animdemo.view;

import androidx.appcompat.app.AppCompatActivity;

/**
 * <p>***********************************************************************
 * <p> Description: 代理Activity
 * <p>
 * <p>***********************************************************************
 */

public class GMCompatActivity extends AppCompatActivity {

//    代理textView和EditText取消
    private GMCompatDelegate delegate;
//
//    @NonNull
//    @Override
//    public GMCompatDelegate getDelegate() {
//        if (null == delegate) {
//            delegate = new GMCompatDelegate(GMCompatActivity.this, getWindow(), this);
//        }
//        return delegate;
//    }
}
