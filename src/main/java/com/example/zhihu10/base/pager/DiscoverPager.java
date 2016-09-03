package com.example.zhihu10.base.pager;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu10.R;
import com.example.zhihu10.base.BasePager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.BaseDetailPager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.CollectDetailPager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.HotDetailPager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.RecommendDetailPager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.RoundTableDetailPager;

import java.util.ArrayList;

/**
 * Created by Xu on 2016/8/20.
 */
public class DiscoverPager extends BasePager {

    private ViewPager vp_discover;
    private ArrayList<BaseDetailPager> mDiscoverDetailPagers;
    private ArrayList<String> mPagerTitles;

    public DiscoverPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_discover,null);
        vp_discover = (ViewPager)view.findViewById(R.id.vp_discover);
        if(vp_discover!=null){
            setUpViewPager(vp_discover);
        }

        //找到了tabLayout
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs_discover);
        //给viewpager 关联一共tablayotu
        tabLayout.setupWithViewPager(vp_discover);
        tabLayout.setTabTextColors(R.color.lightwhite,Color.WHITE);
        return view;
    }

    @Override
    public void initData() {


    }

    private void setUpViewPager(ViewPager viewPager) {
        DiscoverAdapter adapter = new DiscoverAdapter();
        mDiscoverDetailPagers = new ArrayList<BaseDetailPager>();
        mPagerTitles = new ArrayList<String>();
        adapter.addDetailPager(new RecommendDetailPager(mActivity),"推荐");
        adapter.addDetailPager(new RoundTableDetailPager(mActivity),"圆桌");
        adapter.addDetailPager(new HotDetailPager(mActivity),"热门");
        adapter.addDetailPager(new CollectDetailPager(mActivity),"收藏");

        viewPager.setAdapter(adapter);
    }

    private class DiscoverAdapter extends PagerAdapter {

        public void addDetailPager(BaseDetailPager pager, String title) {
            //添加Fragment
            mDiscoverDetailPagers.add(pager);
            //添加标题
            mPagerTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mPagerTitles.get(position);
        }

        @Override
        public int getCount() {
            return mPagerTitles.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BaseDetailPager baseDetailPager = mDiscoverDetailPagers.get(position);
            View view = baseDetailPager.myRootView;
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }


    }


}
