package com.chatgame.todaynews.ui.activity;


import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import com.chatgame.todaynews.R;
import com.chatgame.todaynews.base.BaseMvpActivity;
import com.chatgame.todaynews.presenter.MainPresenter;
import com.chatgame.todaynews.presenter.contract.MainContract;
import com.chatgame.todaynews.ui.fragment.MainFirstFragment;
import com.chatgame.todaynews.ui.fragment.MainMinTopFragment;
import com.chatgame.todaynews.ui.fragment.MainMineFragment;
import com.chatgame.todaynews.ui.fragment.MainVideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.view_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.rg_main_tab)
    RadioGroup mFooterTab;

    private Fragment mCurrentFragment;

    private List<Fragment> mFragments;

    private int mTabIndex = 0;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndaData() {
        setToolbar(mToolbar, "测试");
        initFragment();
        mFooterTab.setOnCheckedChangeListener(new MainCheckedChangeListener());
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    public void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new MainFirstFragment());
        mFragments.add(new MainVideoFragment());
        mFragments.add(new MainMinTopFragment());
        mFragments.add(new MainMineFragment());
        changeTab(0);
    }



    public Fragment getFragment(int position) {
        return mFragments.get(position);
    }

    private class MainCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.rb_main_first:
                    mTabIndex = 0;
                    changeTab(mTabIndex);
                    break;
                case R.id.rb_main_video:
                    mTabIndex = 1;
                    changeTab(mTabIndex);
                    break;
                case R.id.rb_main_min_top:
                    mTabIndex = 2;
                    changeTab(mTabIndex);
                    break;
                case R.id.rb_main_mine:
                    mTabIndex = 3;
                    changeTab(mTabIndex);
                    break;
                default:
                    break;
            }
        }
    };

    private void changeTab(int index) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (mCurrentFragment != null) {
            ft.hide(mCurrentFragment);
        }
        Fragment fragment = fm.findFragmentByTag(mFragments.get(index).getClass().getName());
        if (null == fragment) {
            fragment = mFragments.get(index);
        }
        mCurrentFragment = fragment;
        if (!fragment.isAdded()) {
            ft.add(R.id.fl_main_content, fragment, fragment.getClass().getName());
        } else {
            ft.show(fragment);
        }
        ft.commit();
    }
}
