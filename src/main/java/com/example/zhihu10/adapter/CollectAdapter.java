package com.example.zhihu10.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhihu10.MyApp;
import com.example.zhihu10.R;
import com.example.zhihu10.global.GlobalDatas;

/**
 * Created by Xu on 2016/8/27.
 */
public class CollectAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return GlobalDatas.mCollectGivenName.length;
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
        if(convertView==null){
            view = View.inflate(MyApp.getContext(), R.layout.item_listview_collect,null);
        } else {
            view = convertView;
        }

        ImageView iv_collect_icon =  (ImageView)view.findViewById(R.id.iv_collect_icon);
        TextView tv_collect_concern = (TextView) view.findViewById(R.id.tv_collect_concern);
        TextView tv__collect_title = (TextView) view.findViewById(R.id.tv_collect_title);
        TextView tv_collect_givenname = (TextView) view.findViewById(R.id.tv_collect_givenname);

        iv_collect_icon.setImageResource(GlobalDatas.mCollectIcons[position]);
        tv_collect_concern.setText(GlobalDatas.mCollectConcern[position]+"人关注");
        tv__collect_title.setText(GlobalDatas.mCollectTitles[position]);
        tv_collect_givenname.setText("由"+GlobalDatas.mCollectGivenName[position]+"创建");
        return view;

    }
}
