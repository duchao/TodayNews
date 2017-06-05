package com.chatgame.todaynews.di.component;

import android.app.Activity;

import com.chatgame.todaynews.di.module.FragmentModule;
import com.chatgame.todaynews.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by duchao on 2017/6/5.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();
}
