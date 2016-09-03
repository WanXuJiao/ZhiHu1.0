package com.example.zhihu10.base.detailpager.discoverdetailpager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhihu10.MyApp;
import com.example.zhihu10.R;
import com.example.zhihu10.adapter.RoundTableAdapter;

/**
 * Created by Xu on 2016/8/21.
 */
public class RoundTableDetailPager extends BaseDetailPager {
    private ListView lv_detailpager;

    public RoundTableDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(MyApp.getContext(), R.layout.detailpage_listview,null);
        lv_detailpager = (ListView)view.findViewById(R.id.lv_detailpager);

        lv_detailpager.setAdapter(new RoundTableAdapter());
        return view;
    }

    @Override
    public void initData() {

    }
}
