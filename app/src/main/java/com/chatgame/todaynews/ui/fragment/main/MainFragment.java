package com.chatgame.todaynews.ui.fragment.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.chatgame.todaynews.R;
import com.chatgame.todaynews.base.BaseSimpleFragment;
import com.chatgame.todaynews.ui.adapter.MainFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by duchao on 2017/6/6.
 */

public class MainFragment extends BaseSimpleFragment {

    @BindView(R.id.tl_main_tab)
    TabLayout mTitleTab;
    @BindView(R.id.vp_main_content)
    ViewPager mContainter;

    @BindView(R.id.tv_main_search)
    TextView mSearchText;

    private List<Fragment> mFragmentList;

    private List<String> mTitleList;

    private MainFragmentAdapter mMainFragmentAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initEventAndData() {
        mFragmentList = new ArrayList<>();
        initFragment(mFragmentList);
        mTitleList = new ArrayList<>();
        initTitles(mTitleList);
        mMainFragmentAdapter = new MainFragmentAdapter(getFragmentManager(),mFragmentList, mTitleList);
        mContainter.setAdapter(mMainFragmentAdapter);
        mTitleTab.setupWithViewPager(mContainter);
    }

    private void initFragment(List<Fragment> fragmentList) {
        if (fragmentList == null) {
            return;
        }
        fragmentList.clear();
        fragmentList.add(new MainAnswerFragment());
        fragmentList.add(new MainCarFragment());
        fragmentList.add(new MainEntertainmentFragment());
        fragmentList.add(new MainFinaceFragment());
        fragmentList.add(new MainFunPhotoFragment());
        fragmentList.add(new MainGirlFragment());
        fragmentList.add(new MainHealthFragment());
        fragmentList.add(new MainHotFragment());
        fragmentList.add(new MainHouseFragment());
        fragmentList.add(new MainJokeFragment());
        fragmentList.add(new MainInternationFragment());
    };

    private void initTitles(List<String> titleList) {
        if (titleList == null) {
            return;
        }
        titleList.clear();
        titleList.add("问答");
        titleList.add("汽车");
        titleList.add("娱乐");
        titleList.add("金融");
        titleList.add("趣图");
        titleList.add("美女");
        titleList.add("健康");
        titleList.add("热点");
        titleList.add("房产");
        titleList.add("段子");
        titleList.add("国际");
    }

    private boolean isOpen = true;
    @OnClick(R.id.tv_main_search)
    void jumpToSearch() {
        if (isOpen) {
            mSearchText.setText("123");
            isOpen = false;
        } else {
            mSearchText.setText("djsldjfsljfdsljfd地方的实例就发酸辣粉的律师费是劳动法思路法律手段发");
            isOpen = true;
        }
    }
}
