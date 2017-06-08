package com.chatgame.todaynews.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chatgame.todaynews.utils.LogUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by duchao on 2017/6/5.
 */

public abstract class BaseFragment extends LazyFragment {

    private Unbinder mUnbinder;

    protected Activity mActivity;

    private Context mContext;

    protected View mView;

    protected abstract int getLayout();

    protected abstract void initEventAndData();

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
        LogUtils.d(getClass().getName(),"onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayout(), null);
        LogUtils.d(getClass().getName(),"onCreateView");
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        initEventAndData();
        LogUtils.d(getClass().getName(),"onViewCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        LogUtils.d(getClass().getName(),"onDestroyView");
    }

    protected void intent2Activity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(mContext, tarActivity);
        startActivity(intent);
    }
}
