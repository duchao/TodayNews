package com.chatgame.todaynews.presenter;

import com.chatgame.todaynews.base.RxPresenter;
import com.chatgame.todaynews.presenter.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by duchao on 2017/6/6.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {

    }
}
