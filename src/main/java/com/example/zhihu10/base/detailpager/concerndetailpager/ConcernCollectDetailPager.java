package com.example.zhihu10.base.detailpager.concerndetailpager;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;

import com.example.zhihu10.MyApp;
import com.example.zhihu10.R;
import com.example.zhihu10.adapter.CollectAdapter;
import com.example.zhihu10.adapter.ConcernCollectAdapter;
import com.example.zhihu10.base.detailpager.discoverdetailpager.BaseDetailPager;

/**
 * Created by Xu on 2016/8/21.
 */
public class ConcernCollectDetailPager extends BaseDetailPager {

    public ConcernCollectDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(MyApp.getContext(), R.layout.detail_pager_collect,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
