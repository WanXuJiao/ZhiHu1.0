package com.example.zhihu10.base.detailpager.discoverdetailpager;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhihu10.MyApp;
import com.example.zhihu10.R;
import com.example.zhihu10.global.GlobalDatas;

/**
 * Created by Xu on 2016/8/21.
 */
public class RecommendDetailPager extends BaseDetailPager {

    private ListView lv_detailpager;

    public RecommendDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View recommendView = View.inflate(MyApp.getContext(), R.layout.detailpage_listview, null);
        lv_detailpager = (ListView) recommendView.findViewById(R.id.lv_detailpager);
        initData();
        return recommendView;
    }

    @Override
    public void initData() {
        lv_detailpager.setAdapter(new RecommendAdapter());
    }

    private class RecommendAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return GlobalDatas.mHeads.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            if (convertView == null) {
                view = View.inflate(MyApp.getContext(), R.layout.item_listview_recommend, null);
            } else {
                view = convertView;
            }
            ImageView iv_recommend_background = (ImageView) view.findViewById(R.id.iv_recommend_background);
            ImageView iv_recommend_icon = (ImageView) view.findViewById(R.id.iv_recommend_icon);
            TextView tv_recommend_givenname = (TextView) view.findViewById(R.id.tv_recommend_givenname);

            tv_recommend_givenname.setText(GlobalDatas.mGivenNames[position]);
            iv_recommend_icon.setImageResource(GlobalDatas.mHeads[position]);
            iv_recommend_background.setImageResource(GlobalDatas.mBackgrounds[position]);

            return view;
        }
    }
}
