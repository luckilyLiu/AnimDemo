package com.gengmei.animdemo.adapter;

import android.content.Context;

import com.gengmei.animdemo.bean.CardBean;

import java.util.List;

import androidx.annotation.NonNull;

public class MultiTypeAdapter extends CardViewAdapter {

    public MultiTypeAdapter(@NonNull Context context, List<CardBean> beans) {
        super(context, beans);
    }

}
