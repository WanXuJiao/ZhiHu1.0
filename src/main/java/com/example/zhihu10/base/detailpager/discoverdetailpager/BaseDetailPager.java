package com.example.zhihu10.base.detailpager.discoverdetailpager;

import android.app.Activity;
import android.view.View;

/**
 * Created by Xu on 2016/8/21.
 */
public abstract class BaseDetailPager {

    public Activity mActivity;
    public View myRootView;  //discover与notification详情页根布局

    public BaseDetailPager(Activity activity){
        mActivity = activity;

        myRootView = initView();
    }

    /**
     * 初始化布局,必须子类实现
     * */
    public abstract View initView();

    /**
     * 初始化数据
     * */
    public abstract void initData();

}
