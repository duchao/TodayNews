package com.chatgame.todaynews.di.component;

import com.chatgame.todaynews.app.App;
import com.chatgame.todaynews.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by duchao on 2017/6/5.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    App getContext();
}
