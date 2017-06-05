package com.chatgame.todaynews.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chatgame.todaynews.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by duchao on 2017/6/5.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    protected Activity mActivity;

    protected Context mContext;

    protected abstract int getLayout();
    protected abstract void initEventAndaData();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);
        mActivity = this;
        mContext = this;
        onViewCreated();
        App.getInstance().addActivity(this);
        initEventAndaData();
    }

    protected void beforeSetContentView() {

    }

    protected void onViewCreated() {

    }

    protected void setToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    protected void setToolbar(Toolbar toolbar, int titleId) {
        setToolbar(toolbar, getString(titleId));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        mUnbinder.unbind();
    }

    protected void intent2Activity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(mContext, tarActivity);
        startActivity(intent);
    }
}
