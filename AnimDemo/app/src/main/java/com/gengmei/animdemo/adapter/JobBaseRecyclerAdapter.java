package com.gengmei.animdemo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * <p>***********************************************************************
 * <p> Author: liukunyu
 * <p> CreateData: 2020-08-04 17:00
 * <p> Description: recycler适配器
 * <p>
 * <p>***********************************************************************
 */

public abstract class JobBaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * 上下文
     */
    protected Context mContext;
    /**
     * 数据
     */
    public List<T> mBeans = new ArrayList<>();
    /**
     * 去重key集合
     */
    protected Set<String> hashSet = new HashSet<>();
    /**
     * 去重的key
     */
    protected String mDeduplicationKey;
    /**
     * 获取数据起始位置
     */
    public int startNum = 0;

    public interface OnItemClickListener {
        void onItemClicked(int position, View v);
    }

    public JobBaseRecyclerAdapter(@NonNull Context context, List<T> beans) {
        mContext = context;
        mBeans = null == beans ? new ArrayList<T>() : beans;
        startNum = mBeans.size();
    }

    /**
     * @param context
     * @param beans
     * @param deduplicationKey 去重的key
     */
    public JobBaseRecyclerAdapter(@NonNull Context context, List<T> beans, String deduplicationKey) {
        mContext = context;
        mDeduplicationKey = deduplicationKey;
        if (null == beans) {
            return;
        }
        List<T> tempList = new ArrayList<>(beans);
        mBeans = beans;
        mBeans.clear();
        addWithoutDuplicate(tempList);
    }

    /**
     * 插入一个item
     *
     * @param location
     * @param item
     * @return
     */
    public boolean insertItem(int location, T item) {
        try {
            mBeans.add(location, item);
//            notifyItemInserted(location);
            notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除一个item
     *
     * @param location
     * @return
     */
    public boolean deleteItem(int location) {
        try {
            mBeans.remove(location);
//            notifyItemRemoved(location);
            notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除一个item
     *
     * @param item
     * @return
     */
    public boolean deleteItem(T item) {
        try {
            mBeans.remove(item);
//            notifyItemRemoved(mBeans.indexOf(item));
            notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新一个item
     *
     * @param location
     * @param item
     * @return
     */
    public boolean updateItem(int location, T item) {
        try {
            mBeans.set(location, item);
//            notifyItemChanged(location);
            notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加数据并去重
     *
     * @param data
     */
    public void addWithoutDuplicate(List<T> data) {
        if (null == data || data.size() == 0) {
            notifyDataSetChanged();
            return;
        }
        startNum += data.size();
        int position = mBeans.size();
        if (TextUtils.isEmpty(mDeduplicationKey)) {
            new RuntimeException("please input the deduplicationKey in Constructor").printStackTrace();
            mBeans.addAll(data);
//            notifyItemRangeInserted(position, data.size());
            notifyDataSetChanged();
            return;
        }
        for (T item : data) {
            try {
                String keyValue = item.getClass().getDeclaredField(mDeduplicationKey).get(item).toString();
                if (hashSet.add(keyValue)) {
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

    /**
     * 添加数据（去重）
     *
     * @param location
     * @param data
     * @return 是否插入成功
     */
    public void addWithoutDuplicate(int location, List<T> data) {
        if (null == data || data.size() == 0) {
            notifyDataSetChanged();
            return;
        }
        startNum += data.size();
        if (TextUtils.isEmpty(mDeduplicationKey)) {
            new RuntimeException("please input the deduplicationKey in Constructor").printStackTrace();
            mBeans.addAll(data);
            notifyDataSetChanged();
            return;
        }
        List<T> newList = new ArrayList<>();
        for (T item : data) {
            try {
                String keyValue = item.getClass().getDeclaredField(mDeduplicationKey).get(item).toString();
                if (hashSet.add(keyValue)) {
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

    /**
     * 增加数据
     *
     * @param beans
     */
    public void addData(List<T> beans) {
        if (null == beans || beans.size() == 0) {
            return;
        }
//        int location = mBeans.size();
        mBeans.addAll(beans);
        startNum += beans.size();
//        notifyItemRangeInserted(location, beans.size());
        notifyDataSetChanged();
    }

    /**
     * 设置数据
     *
     * @param beans
     */
    public void setData(List<T> beans) {
        if (null == beans) {
            beans = new ArrayList<>();
        }
        mBeans = beans;
        startNum = beans.size();
        notifyDataSetChanged();
    }

    /**
     * 获取数据起始位置
     *
     * @return
     */
    public int getStartNum() {
        return startNum;
    }

    /**
     * 重置数据起始位置
     */
    public void resetStartNum() {
        startNum = 0;
        hashSet.clear();
    }

    /**
     * 刷新数据
     */
    public void refresh(){
        startNum = 0;
        mBeans.clear();
        hashSet.clear();
    }

    /**
     * 获取上下文
     *
     * @return {@link Context}
     */
    public Context getContext() {
        return mContext;
    }


    @Override
    public int getItemCount() {
        return null == mBeans ? 0 : mBeans.size();
    }

    public static class JobBaseRecyclerViewHolder extends RecyclerView.ViewHolder {

        public JobBaseRecyclerViewHolder(View itemView) {
            super(itemView);
//            ButterKnife.bind(this, itemView);
        }
    }
}
