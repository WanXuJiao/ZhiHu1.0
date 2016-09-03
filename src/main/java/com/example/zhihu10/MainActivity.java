package com.example.zhihu10;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.zhihu10.base.BasePager;
import com.example.zhihu10.base.pager.DiscoverPager;
import com.example.zhihu10.base.pager.FeedPager;
import com.example.zhihu10.base.pager.MessagePager;
import com.example.zhihu10.base.pager.MorePager;
import com.example.zhihu10.base.pager.NotificationPager;
import com.example.zhihu10.ui.NoScrollViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private NoScrollViewPager viewPager;
    private ArrayList<BasePager> mPagers;
    private ImageView iv_menu_feed;
    private ImageView iv_menu_discover;
    private ImageView iv_menu_notification;
    private ImageView iv_menu_message;
    private ImageView iv_menu_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MyApp.myThemeType);
        //设置主题一定要在setContentView()方法之前
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initView() {
        viewPager = (NoScrollViewPager)findViewById(R.id.viewpager);

        iv_menu_feed = (ImageView)findViewById(R.id.iv_menu_feed);
        iv_menu_discover = (ImageView)findViewById(R.id.iv_menu_discover);
        iv_menu_notification = (ImageView)findViewById(R.id.iv_menu_notification);
        iv_menu_message = (ImageView)findViewById(R.id.iv_menu_message);
        iv_menu_more = (ImageView)findViewById(R.id.iv_menu_more);

    }

    private void initData() {
        mPagers = new ArrayList<BasePager>();
        mPagers.add(new FeedPager(this));
        mPagers.add(new DiscoverPager(this));
        mPagers.add(new NotificationPager(this));
        mPagers.add(new MessagePager(this));
        mPagers.add(new MorePager(this));

        viewPager.setAdapter(new ContentAdapter());

        iv_menu_feed.setOnClickListener(this);
        iv_menu_discover.setOnClickListener(this);
        iv_menu_notification.setOnClickListener(this);
        iv_menu_message.setOnClickListener(this);
        iv_menu_more.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_menu_feed:
                viewPager.setCurrentItem(0,false);

                //iv_menu_feed.setColorFilter(R.color.titleblue);
                break;
            case R.id.iv_menu_discover:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.iv_menu_notification:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.iv_menu_message:
                viewPager.setCurrentItem(3,false);
                break;
            case R.id.iv_menu_more:
                viewPager.setCurrentItem(4,false);
                break;
        }
    }

    class ContentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagers.get(position);
            View view = pager.mRootView; // 获取当前页面对象的布局
            //pager.initData();   //初始化数据  viewpager会默认加载下一个页面,为了节省流量和性能,不要在此处调用初始化数据的方法
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

}
