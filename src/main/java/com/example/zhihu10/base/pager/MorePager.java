package com.example.zhihu10.base.pager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.example.zhihu10.MainActivity;
import com.example.zhihu10.MyApp;
import com.example.zhihu10.R;
import com.example.zhihu10.activity.MyCollectActivity;
import com.example.zhihu10.activity.MyConcernActivity;
import com.example.zhihu10.activity.MyDraftActivity;
import com.example.zhihu10.base.BasePager;
import com.example.zhihu10.ui.MorePersonalSettingItem;

/**
 * Created by Xu on 2016/8/20.
 */
public class MorePager extends BasePager implements View.OnClickListener{
    private MorePersonalSettingItem msi_my_collect;
    private MorePersonalSettingItem msi_my_concern;
    private MorePersonalSettingItem msi_my_draft;
    private MorePersonalSettingItem msi_my_live;
    private MorePersonalSettingItem msi_my_scan_nearby;
    private MorePersonalSettingItem msi_my_zhihu;
    private MorePersonalSettingItem msi_night_mode;
    private MorePersonalSettingItem msi_my_setting;
    private Switch switch_more;

    //实现夜间模式代码
    /*private MorePersonalSettingItem mpst_night_mode;
    private Switch switch_more;
    private boolean isNightMode = false;*/

    public MorePager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {

        //加载布局
        View view = View.inflate(mActivity, R.layout.pager_more,null);
        msi_my_collect = (MorePersonalSettingItem)view.findViewById(R.id.msi_my_collect);
        msi_my_concern = (MorePersonalSettingItem)view.findViewById(R.id.msi_my_concern);
        msi_my_draft = (MorePersonalSettingItem)view.findViewById(R.id.msi_my_draft);
        msi_my_live = (MorePersonalSettingItem)view.findViewById(R.id.msi_my_live);
        msi_my_scan_nearby = (MorePersonalSettingItem)view.findViewById(R.id.msi_my_scan_nearby);
        msi_my_zhihu = (MorePersonalSettingItem)view.findViewById(R.id.msi_my_zhihu);
        msi_night_mode = (MorePersonalSettingItem)view.findViewById(R.id.msi_night_mode);
        msi_my_setting = (MorePersonalSettingItem)view.findViewById(R.id.msi_my_setting);
        switch_more = (Switch) msi_night_mode.findViewById(R.id.switch_more);
        initListener();
        initData();
        return view;
    }

    private void initListener() {
        msi_my_collect.setOnClickListener(this);
        msi_my_concern.setOnClickListener(this);
        msi_my_draft.setOnClickListener(this);
        msi_my_live.setOnClickListener(this);
        msi_my_scan_nearby.setOnClickListener(this);
        msi_my_zhihu.setOnClickListener(this);
        switch_more.setOnClickListener(this);
        msi_my_setting.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.msi_my_concern:
                mActivity.startActivity(new Intent(mActivity, MyConcernActivity.class));
                break;
            case R.id.msi_my_collect:
                mActivity.startActivity(new Intent(mActivity, MyCollectActivity.class));
                break;
            case R.id.msi_my_draft:
                mActivity.startActivity(new Intent(mActivity, MyDraftActivity.class));
                break;
            case R.id.msi_my_scan_nearby:
                Toast.makeText(MyApp.getContext(),"scan_nearby",Toast.LENGTH_SHORT).show();
                break;
            case R.id.msi_my_zhihu:
                Toast.makeText(MyApp.getContext(),"zhihu",Toast.LENGTH_SHORT).show();
                break;
            case R.id.msi_my_live:
                Toast.makeText(MyApp.getContext(),"live",Toast.LENGTH_SHORT).show();
                break;
            case R.id.switch_more:
                Toast.makeText(MyApp.getContext(),"switch_more",Toast.LENGTH_SHORT).show();
                if(MyApp.myThemeType == MyApp.DAY_THEME){
                    MyApp.myThemeType =MyApp.NIGHT_THEME;
                } else {
                    MyApp.myThemeType = MyApp.DAY_THEME;
                }
                mActivity.recreate();
                break;
            case R.id.msi_my_setting:
                Toast.makeText(MyApp.getContext(),"setting",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
