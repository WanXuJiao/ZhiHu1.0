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
public class RoundTableAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return GlobalDatas.mRoundTableTitles.length;
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
            view = View.inflate(MyApp.getContext(), R.layout.item_listview_roundtable,null);
        } else {
            view = convertView;
        }

       ImageView iv_table_background =  (ImageView)view.findViewById(R.id.iv_table_background);
       TextView tv_table_lookaround = (TextView) view.findViewById(R.id.tv_table_lookaround);
        TextView tv_roundtable_title = (TextView) view.findViewById(R.id.tv_roundtable_title);

        iv_table_background.setImageResource(GlobalDatas.myRoundTableBackground[position]);
        tv_table_lookaround.setText(GlobalDatas.mRoundTableLookaround[position]);
        tv_roundtable_title.setText(GlobalDatas.mRoundTableTitles[position]);
        return view;
    }
}
