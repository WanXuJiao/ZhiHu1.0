package com.example.zhihu10.base;

import android.app.Activity;
import android.view.View;

/**
 * Created by Xu on 2016/8/19.
 */
public abstract class BasePager {
    public Activity mActivity;
    public View mRootView;

    public BasePager(Activity mActivity) {
        this.mActivity = mActivity;
        mRootView = initView();
        initData();
    }

    public abstract View initView();

    public abstract void initData();
}
