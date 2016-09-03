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
public class HotDetailPager extends BaseDetailPager {
    public HotDetailPager(Activity activity) {
        super(activity);
    }
    private ListView lv_detailpager;

    @Override
    public View initView() {
        View HotView = View.inflate(MyApp.getContext(), R.layout.detailpage_listview, null);
        lv_detailpager = (ListView) HotView.findViewById(R.id.lv_detailpager);
        initData();
        return HotView;
    }

    @Override
    public void initData() {
        lv_detailpager.setAdapter(new HotAdapter());
    }

    private class HotAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return GlobalDatas.mNoticeIcons.length;
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
                view = View.inflate(MyApp.getContext(), R.layout.item_listview_hot, null);
            } else {
                view = convertView;
            }
            ImageView iv_hot_icon = (ImageView) view.findViewById(R.id.iv_hot_icon);
            TextView tv_hot_givenname = (TextView) view.findViewById(R.id.tv_hot_givenname);
            TextView tv_hot_title = (TextView) view.findViewById(R.id.tv_hot_title);

            tv_hot_title.setText(GlobalDatas.getmNoticeTitles[position]);
            tv_hot_givenname.setText(GlobalDatas.mGivenNames[position]);
            iv_hot_icon.setImageResource(GlobalDatas.mNoticeIcons[position]);

            return view;
        }
    }
}
