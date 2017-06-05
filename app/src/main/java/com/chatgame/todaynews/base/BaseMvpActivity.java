package com.chatgame.todaynews.base;

import com.chatgame.todaynews.app.App;
import com.chatgame.todaynews.di.component.ActivityComponent;
import com.chatgame.todaynews.di.component.DaggerActivityComponent;
import com.chatgame.todaynews.di.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by duchao on 2017/6/5.
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {
    @Inject
    protected T mPresenter;

    protected abstract void initInject();

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
