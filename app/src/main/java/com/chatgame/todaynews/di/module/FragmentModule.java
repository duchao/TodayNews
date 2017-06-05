package com.chatgame.todaynews.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.chatgame.todaynews.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by duchao on 2017/6/5.
 */
@Module
public class FragmentModule {
    private Fragment mFragment;
    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return mFragment.getActivity();
    }
}
