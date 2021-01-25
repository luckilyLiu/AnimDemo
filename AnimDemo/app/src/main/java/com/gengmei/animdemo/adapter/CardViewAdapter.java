package com.gengmei.animdemo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gengmei.animdemo.bean.CardBean;
import com.gengmei.animdemo.cards.CardViewProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * <p>***********************************************************************
 * <p> Author: liukunyu
 * <p> CreateData: 2020-11-18 16:30
 * <p> Description: 卡片列表适配器
 * <p>
 * <p>***********************************************************************
 */

public class CardViewAdapter extends JobBaseRecyclerAdapter<CardBean> {

    private LayoutInflater inflater;

    private Map<Integer, CardViewProvider> providers = new HashMap<>();

    public CardViewAdapter(@NonNull Context context, List<CardBean> beans) {
        super(context, beans, "uniqueId");
    }

    /**
     * 注册卡片
     *
     * @param cardType         int
     * @param cardViewProvider card
     * @return
     */
    public CardViewAdapter registerCard(int cardType, CardViewProvider cardViewProvider) {
        providers.put(cardType, cardViewProvider);
        return this;
    }

    /**
     * 移除注册的卡片
     * @param cardType int
     * @return
     */
    public CardViewAdapter unregisterCard(int cardType){
        providers.remove(cardType);
        return this;
    }

    /**
     * 获取已注册的卡片
     *
     * @param cardType int
     * @return
     */
    public CardViewProvider getRegisteredCard(int cardType) {
        return providers.get(cardType);
    }

    @Override
    public void addWithoutDuplicate(List<CardBean> data) {
        if (null == data || data.size() == 0) {
            return;
        }
        startNum += data.size();
        for (CardBean item : data) {
            try {
                String keyValue = item.getUniqueId();
                if (TextUtils.isEmpty(keyValue)) {
                    mBeans.add(item);
                } else if (hashSet.add(keyValue)) {
                    mBeans.add(item);
                }
            } catch (Exception e) {
                e.printStackTrace();
                mBeans.add(item);
            }
        }
//        notifyItemRangeInserted(position, mBeans.size() - position);
        notifyDataSetChanged();
    }

    @Override
    public void addWithoutDuplicate(int location, List<CardBean> data) {
        if (null == data || data.size() == 0) {
            return;
        }
        startNum += data.size();
        List<CardBean> newList = new ArrayList<>();
        for (CardBean item : data) {
            try {
                String keyValue = item.getUniqueId();
                if (TextUtils.isEmpty(keyValue)) {
                    newList.add(item);
                } else if (hashSet.add(keyValue)) {
                    newList.add(item);
                }
            } catch (Exception e) {
                e.printStackTrace();
                newList.add(item);
            }
        }
        mBeans.addAll(location, newList);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        CardViewProvider provider = providers.get(viewType);
        if (null == provider) {
            Log.d("CardViewAdapter", "未找到匹配的卡片类型，请确认是否已经注册卡片");
            return null;
        }
        provider.adapter = CardViewAdapter.this;
        return provider.onCreateViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final CardViewProvider provider = providers.get(holder.getItemViewType());
        if (null != provider) {
            provider.onBindViewHolder((JobBaseRecyclerViewHolder) holder, mBeans.get(position), position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    provider.onCardItemClick(v, mBeans.get(position), position);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mBeans.get(position).getCardType();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }
}
