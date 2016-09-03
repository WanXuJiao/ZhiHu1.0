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
 * Created by Xu on 2016/8/26.
 */
public class ConcernAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return GlobalDatas.mConcernGivenNames.length;
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
            view = View.inflate(MyApp.getContext(), R.layout.item_listview_concern,null);
        } else {
            view = convertView;
        }
        ImageView iv_concern_icon =(ImageView) view.findViewById(R.id.iv_concern_icon);
        TextView tv_concern_givenname = (TextView)view.findViewById(R.id.tv_concern_givenname);
        TextView tv_concern_title = (TextView)view.findViewById(R.id.tv_concern_title);

        iv_concern_icon.setImageResource(GlobalDatas.mConcernIcons[position]);
        tv_concern_givenname.setText(GlobalDatas.mConcernGivenNames[position]);
        tv_concern_title.setText(GlobalDatas.mConcernTitles[position]);
        return view;
    }
}
