package com.chatgame.todaynews.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by duchao on 2017/6/7.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    private List<String> mTitleList;

    public MainFragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titleList) {
        super(fm);
        mFragmentList = fragments;
        mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = mTitleList.get(position);
        return title == null ? "" : title;
    }
}
