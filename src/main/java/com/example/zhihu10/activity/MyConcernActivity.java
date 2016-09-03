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
import com.example.zhihu10.base.detailpager.concerndetailpager.ConcernColumnDetailPager;
import com.example.zhihu10.base.detailpager.concerndetailpager.ConcernQuestionDetailPager;
import com.example.zhihu10.base.detailpager.concerndetailpager.ConcernTopicDetailPager;
import com.example.zhihu10.base.detailpager.concerndetailpager.ConcernUserDetailPager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.BaseDetailPager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.CollectDetailPager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.HotDetailPager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.RecommendDetailPager;
import com.example.zhihu10.base.detailpager.discoverdetailpager.RoundTableDetailPager;

import java.util.ArrayList;

/**
 * Created by Xu on 2016/8/30.
 */
public class MyConcernActivity extends AppCompatActivity {

    private TabLayout tab_my_concern;
    private ViewPager vp_my_concern;
    private ArrayList<BaseDetailPager> myConcernDetailPagers;
    private ArrayList<String> mPagerTitles;
    private ImageView iv_my_concern_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_concern);
        initView();
    }

    private void initView() {
        tab_my_concern = (TabLayout)findViewById(R.id.tab_my_concern);
        vp_my_concern = (ViewPager)findViewById(R.id.vp_my_concern);
        iv_my_concern_back = (ImageView)findViewById(R.id.iv_my_concern_back);
        if(vp_my_concern!=null){
            setUpViewPager(vp_my_concern);
        }

        tab_my_concern.setupWithViewPager(vp_my_concern);
        tab_my_concern.setTabTextColors(R.color.lightwhite, Color.WHITE);

        iv_my_concern_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setUpViewPager(ViewPager viewPager) {
        MyConcernAdapter adapter = new MyConcernAdapter();
        myConcernDetailPagers = new ArrayList<BaseDetailPager>();
        mPagerTitles = new ArrayList<String>();
        adapter.addDetailPager(new ConcernQuestionDetailPager(this),"问题");
        adapter.addDetailPager(new ConcernCollectDetailPager(this),"收藏");
        adapter.addDetailPager(new ConcernTopicDetailPager(this),"话题");
        adapter.addDetailPager(new ConcernColumnDetailPager(this),"专栏");
        adapter.addDetailPager(new ConcernUserDetailPager(this),"用户");

        viewPager.setAdapter(adapter);

    }

    private class MyConcernAdapter extends PagerAdapter {

        public void addDetailPager(BaseDetailPager pager, String title) {
            //添加Fragment
            myConcernDetailPagers.add(pager);
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
            BaseDetailPager baseDetailPager = myConcernDetailPagers.get(position);
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
