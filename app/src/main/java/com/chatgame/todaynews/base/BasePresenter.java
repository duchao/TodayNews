package com.chatgame.todaynews.base;

/**
 * Created by duchao on 2017/6/5.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
