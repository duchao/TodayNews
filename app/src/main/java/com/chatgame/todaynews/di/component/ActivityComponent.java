package com.chatgame.todaynews.di.component;

import android.app.Activity;

import com.chatgame.todaynews.di.module.ActivityModule;
import com.chatgame.todaynews.di.scope.ActivityScope;
import com.chatgame.todaynews.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by duchao on 2017/6/5.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
    void inject(MainActivity mainActivity);
}
