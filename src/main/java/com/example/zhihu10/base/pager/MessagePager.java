package com.example.zhihu10.base.pager;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.zhihu10.MyApp;
import com.example.zhihu10.R;
import com.example.zhihu10.base.BasePager;

/**
 * Created by Xu on 2016/8/20.
 */
public class MessagePager extends BasePager {

    private ListView lv_message;

    public MessagePager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_message,null);
        lv_message = (ListView)view.findViewById(R.id.lv_message);

        lv_message.setAdapter(new MessageAdapter());
        return view;
    }

    @Override
    public void initData() {

    }

    private class MessageAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 8;
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
                view = View.inflate(MyApp.getContext(), R.layout.item_listview_message, null);
            } else {
                view = convertView;
            }
            return view;
        }
    }
}
