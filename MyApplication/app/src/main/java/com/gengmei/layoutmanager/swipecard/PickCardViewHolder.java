package com.gengmei.layoutmanager.swipecard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;


/**
 * 通用的RecyclerView 的ViewHolder ，使用者无需关心
 * Created by zhangxutong .
 * Date: 16/03/11
 */
public class PickCardViewHolder extends BaseViewHolder {
    private SparseArray<View> mViews;
    private int mLayoutId;

    public PickCardViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<View>();
    }

    public static PickCardViewHolder get(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        PickCardViewHolder holder = new PickCardViewHolder(itemView);
        holder.mLayoutId = layoutId;
        return holder;

    }

    public int getLayoutId() {
        return mLayoutId;
    }


    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public PickCardViewHolder setText(int viewId, CharSequence text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public PickCardViewHolder setSelected(int viewId, boolean selected) {
        View v = getView(viewId);
        v.setSelected(selected);
        return this;
    }

    public PickCardViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public PickCardViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public PickCardViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public PickCardViewHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public PickCardViewHolder setBackgroundRes(int viewId, int backgroundRes) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public PickCardViewHolder setTextColor(int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public PickCardViewHolder setTextColorRes(int viewId, int textColorRes) {
        TextView view = getView(viewId);
        view.setTextColor(itemView.getContext().getResources().getColor(textColorRes));
        return this;
    }

    @SuppressLint("NewApi")
    public PickCardViewHolder setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    public PickCardViewHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public PickCardViewHolder linkify(int viewId) {
        TextView view = getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    public PickCardViewHolder setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    public PickCardViewHolder setProgress(int viewId, int progress) {
        ProgressBar view = getView(viewId);
        view.setProgress(progress);
        return this;
    }

    public PickCardViewHolder setProgress(int viewId, int progress, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    public PickCardViewHolder setMax(int viewId, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        return this;
    }

    public PickCardViewHolder setRating(int viewId, float rating) {
        RatingBar view = getView(viewId);
        view.setRating(rating);
        return this;
    }

    public PickCardViewHolder setRating(int viewId, float rating, int max) {
        RatingBar view = getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    public PickCardViewHolder setTag(int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    public PickCardViewHolder setTag(int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    public PickCardViewHolder setChecked(int viewId, boolean checked) {
        Checkable view = (Checkable) getView(viewId);
        view.setChecked(checked);
        return this;
    }

    /**
     * 关于事件的
     */
    public PickCardViewHolder setOnClickListener(int viewId,
                                                 View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public PickCardViewHolder setOnTouchListener(int viewId,
                                                 View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public PickCardViewHolder setOnLongClickListener(int viewId,
                                                     View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }


    /**
     * 隐藏或展示Item
     *
     * @param visible
     */
    public void setItemVisible(boolean visible) {
        if (null != itemView) {
            if (visible) {
                if (null != itemView.getLayoutParams()) {
                    itemView.getLayoutParams().width = AbsListView.LayoutParams.MATCH_PARENT;
                    itemView.getLayoutParams().height = AbsListView.LayoutParams.WRAP_CONTENT;
                } else {
                    itemView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
                }
                itemView.setVisibility(View.VISIBLE);
            } else {
                if (null != itemView.getLayoutParams()) {
                    itemView.getLayoutParams().width = -1;
                    itemView.getLayoutParams().height = 1;
                } else {
                    itemView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                }
                itemView.setVisibility(View.GONE);
            }
        }
    }

    public void setHItemVisible(boolean visible) {
        if (null != itemView) {
            if (visible) {
                if (null != itemView.getLayoutParams()) {
                    itemView.getLayoutParams().width = AbsListView.LayoutParams.WRAP_CONTENT;
                    itemView.getLayoutParams().height = AbsListView.LayoutParams.WRAP_CONTENT;
                } else {
                    itemView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
                }
                itemView.setVisibility(View.VISIBLE);
            } else {
                if (null != itemView.getLayoutParams()) {
                    itemView.getLayoutParams().width = -1;
                    itemView.getLayoutParams().height = 1;
                } else {
                    itemView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                }
                itemView.setVisibility(View.GONE);
            }
        }
    }
}
