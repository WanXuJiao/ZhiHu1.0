package com.example.zhihu10.base.pager;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu10.R;
import com.example.zhihu10.adapter.ConcernAdapter;
import com.example.zhihu10.adapter.NoticeAdapter;
import com.example.zhihu10.adapter.ThankfulAdapter;
import com.example.zhihu10.base.BasePager;
import com.example.zhihu10.base.detailpager.notificationdetailpager.BaseNotificationDetailPager;
import com.example.zhihu10.base.detailpager.notificationdetailpager.ConcernDetailPager;
import com.example.zhihu10.base.detailpager.notificationdetailpager.NoticeDetailPager;
import com.example.zhihu10.base.detailpager.notificationdetailpager.ThankfulDetailPager;

import java.util.ArrayList;

/**
 * Created by Xu on 2016/8/20.
 */
public class NotificationPager extends BasePager {

    private ViewPager vp_notification;
    private ArrayList<BaseNotificationDetailPager> mNotificationDetailPagers;
    private ArrayList<String> mPagerTitles;

    public NotificationPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_notification,null);
        vp_notification = (ViewPager)view.findViewById(R.id.vp_notification);
        if(vp_notification!=null){
            setUpViewPager(vp_notification);
        }

        //找到了tabLayout
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs_notification);
        //给viewpager 关联一共tablayotu
        tabLayout.setupWithViewPager(vp_notification);
        tabLayout.setTabTextColors(R.color.lightwhite, Color.WHITE);
        return view;
    }

    @Override
    public void initData() {

    }

    private void setUpViewPager(ViewPager viewPager) {
        NotificationAdapter adapter = new NotificationAdapter();
        mNotificationDetailPagers = new ArrayList<BaseNotificationDetailPager>();
        mPagerTitles = new ArrayList<String>();
        adapter.addDetailPager(new NoticeDetailPager(mActivity,new NoticeAdapter()),"通知");
        adapter.addDetailPager(new ConcernDetailPager(mActivity,new ConcernAdapter()),"关注");
        adapter.addDetailPager(new ThankfulDetailPager(mActivity,new ThankfulAdapter()),"赞与感谢");

        viewPager.setAdapter(adapter);
    }

    private class NotificationAdapter extends PagerAdapter {

        public void addDetailPager(BaseNotificationDetailPager pager, String title) {
            //添加Fragment
            mNotificationDetailPagers.add(pager);
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
            BaseNotificationDetailPager baseDetailPager = mNotificationDetailPagers.get(position);
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
