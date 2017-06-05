package com.chatgame.todaynews.di.module;

import android.app.Activity;

import com.chatgame.todaynews.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by duchao on 2017/6/5.
 */
@Module
public class ActivityModule {
    private Activity mActivity;
    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
