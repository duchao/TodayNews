package com.chatgame.todaynews.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by duchao on 2017/6/5.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T>  {
    protected T mView;

    protected CompositeDisposable mCompositeDisposable;

    protected void addSubscribe(Disposable subscrition) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscrition);
    }

    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }
    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        unSubscribe();
    }
}
