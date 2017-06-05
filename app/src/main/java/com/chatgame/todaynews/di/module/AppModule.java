package com.chatgame.todaynews.di.module;

import com.chatgame.todaynews.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by duchao on 2017/6/5.
 */
@Module
public class AppModule {
    private App mApp;
    public AppModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return mApp;
    }



}
