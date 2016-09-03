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
public class ConcernQuestionDetailPager extends BaseDetailPager {

    private ListView lv_detailpager;
    public ConcernQuestionDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(MyApp.getContext(), R.layout.detailpage_listview,null);
        lv_detailpager = (ListView)view.findViewById(R.id.lv_detailpager);

        lv_detailpager.setAdapter(new ConcernCollectAdapter(R.layout.item_concern_question_listview));
        return view;
    }

    @Override
    public void initData() {

    }
}
