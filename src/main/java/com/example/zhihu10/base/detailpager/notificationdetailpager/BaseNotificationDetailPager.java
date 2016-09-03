package com.example.zhihu10.base.detailpager.notificationdetailpager;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.zhihu10.MyApp;
import com.example.zhihu10.R;

/**
 * Created by Xu on 2016/8/21.
 */
public abstract class BaseNotificationDetailPager {

    public Activity mActivity;
    private ListView lv_detailpager;
    public View myRootView;  //discover与notification详情页根布局

    public BaseNotificationDetailPager(Activity activity,BaseAdapter adapter){
        mActivity = activity;
        myRootView = initView(adapter);
    }

    /**
     * 初始化布局,必须子类实现
     * */
    public View initView(BaseAdapter adapter){
        View view = View.inflate(MyApp.getContext(), R.layout.detailpage_listview,null);
        lv_detailpager = (ListView)view.findViewById(R.id.lv_detailpager);
        View headView = View.inflate(MyApp.getContext(), R.layout.headview_listview,null);
        lv_detailpager.addHeaderView(headView);
        lv_detailpager.setAdapter(adapter);

        ImageView iv_headview_already_read = (ImageView)headView.findViewById(R.id.iv_headview_already_read);
        iv_headview_already_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGetAllAlreadyReadDialog();
            }

            private void showGetAllAlreadyReadDialog() {
                AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
                //加载对话框的布局文件
                View view = View.inflate(MyApp.getContext(),R.layout.dialog_custom_already_read,null);
                builder.setView(view);
                builder.show();
            }
        });
        return view;
    }


}
