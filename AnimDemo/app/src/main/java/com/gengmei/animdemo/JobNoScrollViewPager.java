package com.gengmei.animdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class JobNoScrollViewPager extends ViewPager {

    private boolean isScrollable = true;


    public JobNoScrollViewPager(Context context) {
        super(context);
    }

    public JobNoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setScrollable(boolean isScrollable) {
        this.isScrollable = isScrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isScrollable) {
            return super.onTouchEvent(ev);
        } else {
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isScrollable) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return false;
        }
    }

}