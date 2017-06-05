package com.chatgame.todaynews.app;

import android.app.Activity;
import android.app.Application;

import com.chatgame.todaynews.component.InitializeService;
import com.chatgame.todaynews.di.component.AppComponent;
import com.chatgame.todaynews.di.component.DaggerAppComponent;
import com.chatgame.todaynews.di.module.AppModule;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by duchao on 2017/6/5.
 */

public class App extends Application {

    private static App INSTANCE;

    private Set<Activity> mAcctivities;

    private static AppComponent mAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        InitializeService.start(this); // to do init
    }

    public static App getInstance() {
        return INSTANCE;
    }

    public void addActivity(Activity activity) {
        if (mAcctivities == null) {
            mAcctivities = new HashSet<>();
        }
        mAcctivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (mAcctivities != null) {
            mAcctivities.remove(activity);
        }
    }

    public void exitApp() {
        if (mAcctivities != null) {
            for(Activity activity: mAcctivities) {
                activity.finish();
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public static AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(INSTANCE))
                    .build();
        }
        return  mAppComponent;
    }
}
