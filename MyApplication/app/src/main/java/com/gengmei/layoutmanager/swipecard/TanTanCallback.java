package com.gengmei.layoutmanager.swipecard;

import android.graphics.Canvas;
import android.util.TypedValue;
import android.view.View;

import com.gengmei.myapplication.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import static com.gengmei.layoutmanager.swipecard.CardConfig.MAX_SHOW_COUNT;
import static com.gengmei.layoutmanager.swipecard.CardConfig.SCALE_GAP;
import static com.gengmei.layoutmanager.swipecard.CardConfig.TRANS_Y_GAP;


/**
 * 介绍：探探效果定制的Callback
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/18.
 */

public class TanTanCallback<T> extends RenRenCallback {
    private static final int MAX_ROTATION = 15;

    //2016 12 26 考虑 探探垂直上下方向滑动，不删除卡片，
    //判断 此次滑动方向是否是竖直的 ，水平方向上的误差(阈值，默认我给了50dp)
    int mHorizontalDeviation;


    public TanTanCallback(RecyclerView rv, RecyclerView.Adapter adapter, List datas) {
        //this(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, rv, adapter, datas);
        super(rv, adapter, datas);
        mHorizontalDeviation = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, mRv.getContext().getResources().getDisplayMetrics());
    }

    public TanTanCallback(int dragDirs, int swipeDirs, RecyclerView rv, RecyclerView.Adapter adapter, List<T> datas) {
        super(dragDirs, swipeDirs, rv, adapter, datas);
    }

    public int getHorizontalDeviation() {
        return mHorizontalDeviation;
    }

    public TanTanCallback setHorizontalDeviation(int horizontalDeviation) {
        mHorizontalDeviation = horizontalDeviation;
        return this;
    }

    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {

        if (isTopViewCenterInHorizontal(viewHolder.itemView)) {
            return Float.MAX_VALUE;
        }
        return super.getSwipeThreshold(viewHolder);
    }

    @Override
    public float getSwipeEscapeVelocity(float defaultValue) {
        View topView = mRv.getChildAt(mRv.getChildCount() - 1);
        if (isTopViewCenterInHorizontal(topView)) {
            return Float.MAX_VALUE;
        }
        return super.getSwipeEscapeVelocity(defaultValue);
    }

    @Override
    public float getSwipeVelocityThreshold(float defaultValue) {

        View topView = mRv.getChildAt(mRv.getChildCount() - 1);
        if (isTopViewCenterInHorizontal(topView)) {
            return Float.MAX_VALUE;
        }
        return super.getSwipeVelocityThreshold(defaultValue);
    }

    /**
     * 返回TopView此时在水平方向上是否是居中的
     * @return
     */
    public boolean isTopViewCenterInHorizontal(View topView) {
        return Math.abs((mRv.getWidth() >> 1) - topView.getX() - (topView.getWidth() >> 1)) < mHorizontalDeviation;
    }


    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        super.onSwiped(viewHolder, direction);
        //如果不需要循环删除
/*        Object remove = mDatas.remove(viewHolder.getLayoutPosition());
        mAdapter.notifyDataSetChanged();*/
//        onSwipeListener.onSwipe(viewHolder.getLayoutPosition(), isLeftSwipe);

        //探探只是第一层加了rotate & alpha的操作
        //对rotate进行复位
        viewHolder.itemView.setRotation(0);
        if (viewHolder instanceof PickCardViewHolder) {
            PickCardViewHolder holder = (PickCardViewHolder) viewHolder;
            holder.setAlpha(R.id.iv_love, 0);
            holder.setAlpha(R.id.iv_del, 0);
        }

    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        //        Log.e("swipecard", "onChildDraw()  viewHolder = [" + viewHolder + "], dX = [" + dX + "], dY = [" + dY + "], actionState = [" + actionState + "], isCurrentlyActive = [" + isCurrentlyActive + "]");
        //探探的效果
        double swipValue = Math.sqrt(dX * dX + dY * dY);
        double fraction = swipValue / getThreshold(viewHolder);
        //边界修正 最大为1
        if (fraction > 1) {
            fraction = 1;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = recyclerView.getChildAt(i);
            //第几层,举例子，count =7， 最后一个TopView（6）是第0层，
            int level = childCount - i - 1;
            if (level > 0) {
                child.setScaleX((float) (1 - SCALE_GAP * level + fraction * SCALE_GAP));

                if (level < MAX_SHOW_COUNT - 1) {
                    child.setScaleY((float) (1 - SCALE_GAP * level + fraction * SCALE_GAP));
                    child.setTranslationY((float) (TRANS_Y_GAP * level - fraction * TRANS_Y_GAP));
                } else {
                    //child.setTranslationY((float) (mTranslationYGap * (level - 1) - fraction * mTranslationYGap));
                }
            } else {
                //探探只是第一层加了rotate & alpha的操作
                //不过他区分左右
                float xFraction = dX / getThreshold(viewHolder);
                //边界修正 最大为1
                if (xFraction > 1) {
                    xFraction = 1;
                } else if (xFraction < -1) {
                    xFraction = -1;
                }
                //rotate
                child.setRotation(xFraction * MAX_ROTATION);

                //自己感受一下吧 Alpha
                if (viewHolder instanceof PickCardViewHolder) {
                    PickCardViewHolder holder = (PickCardViewHolder) viewHolder;
                    if (dX > 0) {
                        //露出左边，喜欢
                        holder.setAlpha(R.id.iv_love, xFraction * 2);
                        holder.setAlpha(R.id.iv_del, 0);
                    } else if (dX < 0) {
                        //露出右边，不喜欢
                        holder.setAlpha(R.id.iv_del, -xFraction * 2);
                        holder.setAlpha(R.id.iv_love, 0);
                    } else {
                        holder.setAlpha(R.id.iv_love, 0);
                        holder.setAlpha(R.id.iv_del, 0);
                    }
                }
            }
        }

        //可以在此判断左右滑：
        float v = mRv.getWidth() / 2 - viewHolder.itemView.getX() - (viewHolder.itemView.getWidth() / 2);
        if (v == 0) return;
        setLeftSwipe(v > 0 ? true : false);
    }
}
