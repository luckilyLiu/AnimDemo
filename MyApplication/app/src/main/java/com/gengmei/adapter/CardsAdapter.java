package com.gengmei.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gengmei.bean.CardBean;
import com.gengmei.myapplication.R;

import java.util.List;

import androidx.annotation.Nullable;

public class CardsAdapter extends BaseQuickAdapter<CardBean.ListBean, BaseViewHolder> {
    public CardsAdapter(int layoutResId, @Nullable List<CardBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CardBean.ListBean item) {
        ImageView ivCard = helper.getView(R.id.pick_iv_cover);
        Glide.with(mContext).load(item.thumb).into(ivCard);
        helper.setText(R.id.tv_title, item.title);
    }
}
