package com.example.zhihu10.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhihu10.R;
import com.example.zhihu10.base.detailpager.concerndetailpager.ConcernCollectDetailPager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.BaseDetailPager;

import java.util.ArrayList;

/**
 * Created by Xu on 2016/8/30.
 */
public class MyDraftActivity extends AppCompatActivity {

    private TabLayout tab_my_draft;
    private ViewPager vp_my_draft;
    private ArrayList<BaseDetailPager> myDraftDetailPagers;
    private ArrayList<String> mPagerTitles;
    private ImageView iv_my_draft_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_draft);

        initView();
    }

    private void initView() {
        tab_my_draft = (TabLayout)findViewById(R.id.tab_my_draft);
        vp_my_draft = (ViewPager)findViewById(R.id.vp_my_draft);
        iv_my_draft_back = (ImageView)findViewById(R.id.iv_my_draft_back);
        if(vp_my_draft!=null){
            setUpViewPager(vp_my_draft);
        }

        tab_my_draft.setupWithViewPager(vp_my_draft);
        tab_my_draft.setTabTextColors(R.color.lightwhite, Color.WHITE);

        iv_my_draft_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        MyDraftAdapter adapter = new MyDraftAdapter();
        myDraftDetailPagers = new ArrayList<BaseDetailPager>();
        mPagerTitles = new ArrayList<String>();
        adapter.addDetailPager(new ConcernCollectDetailPager(this),"回答");
        adapter.addDetailPager(new ConcernCollectDetailPager(this),"文章");

        viewPager.setAdapter(adapter);
    }

    private class MyDraftAdapter extends PagerAdapter {

        public void addDetailPager(BaseDetailPager pager, String title) {
            //添加Fragment
            myDraftDetailPagers.add(pager);
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
            BaseDetailPager baseDetailPager = myDraftDetailPagers.get(position);
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
