package com.gengmei.animdemo;

import android.os.Parcelable;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * <p>***********************************************************************
 * <p> Description: ViewPager的适配器
 * <p>***********************************************************************
 */

public class LivePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private String[] mTitles;

    public LivePagerAdapter(FragmentManager manager, List<Fragment> fragments, String[] titles) {
        super(manager);
        mFragments = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return null == mFragments ? null : mFragments.get(position);
    }

    @Override
    public int getCount() {
        return null == mFragments ? 0 : mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null == mTitles ? "" : mTitles[position];
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
