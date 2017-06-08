package com.chatgame.todaynews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.chatgame.todaynews.utils.LogUtils;

/**
 * Created by duchao on 2017/6/8.
 */

public abstract class LazyFragment extends Fragment {

    private boolean mIsFirst = true;

    private boolean mIsPrepared = false;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        LogUtils.d(getClass().getName(),"onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        mIsPrepared = true;
        if (getUserVisibleHint()) {
            onVisible();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        LogUtils.d(getClass().getName(),"setUserVisibleHint :" + String.valueOf(isVisibleToUser));
        if (mIsPrepared) {
            if (isVisibleToUser) {
                onVisible();
            } else if(getUserVisibleHint()){
                onInVisible();
            }
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtils.d(getClass().getName(),"onHiddenChanged");
        if (!hidden) {
            onVisible();
        } else {
            onInVisible();
        }
    }

    protected void onVisible() {
        LogUtils.e(getClass().getName(),"onVisible");
        if (mIsFirst) {
            lazyLoad();
            mIsFirst = false;
        }
    }

    protected void onInVisible() {
        LogUtils.e(getClass().getName(),"onInVisible");
    }

    protected void lazyLoad() {
        LogUtils.e(getClass().getName(),"lazyLoad");
    }

}
