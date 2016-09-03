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
public class NoticeAdapter extends BaseAdapter {
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
        if(convertView==null){
            view = View.inflate(MyApp.getContext(), R.layout.item_listview_notice,null);
        } else {
            view = convertView;
        }
        ImageView iv_notice_icon =(ImageView) view.findViewById(R.id.iv_notice_icon);
        TextView tv_notice_givenname = (TextView)view.findViewById(R.id.tv_notice_givenname);
        TextView tv_notice_title = (TextView)view.findViewById(R.id.tv_notice_title);

        iv_notice_icon.setImageResource(GlobalDatas.mNoticeIcons[position]);
        tv_notice_givenname.setText(GlobalDatas.mNoticeGivenNames[position]+"新增了文章");
        tv_notice_title.setText(GlobalDatas.getmNoticeTitles[position]);
        return view;
    }
}
