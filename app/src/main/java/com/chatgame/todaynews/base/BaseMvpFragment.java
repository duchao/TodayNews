package com.chatgame.todaynews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.chatgame.todaynews.app.App;
import com.chatgame.todaynews.di.component.DaggerFragmentComponent;
import com.chatgame.todaynews.di.component.FragmentComponent;
import com.chatgame.todaynews.di.module.FragmentModule;

import javax.inject.Inject;

/**
 * Created by duchao on 2017/6/5.
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    @Inject
    protected T mPresenter;

    protected abstract void initInject();

    protected FragmentComponent getFragemntComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    @Override
    public void showErrorMessage(String msg) {

    }
}
