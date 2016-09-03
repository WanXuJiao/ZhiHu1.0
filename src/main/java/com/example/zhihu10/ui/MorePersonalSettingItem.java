package com.example.zhihu10.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.zhihu10.R;

/**
 * Created by Xu on 2016/8/21.
 */
public class MorePersonalSettingItem extends RelativeLayout {

    private static final String NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private ImageView iv_more_icon;
    private ImageView iv_more_line;
    private TextView tv_moretext;
    private Switch switch_more;

    public MorePersonalSettingItem(Context context) {
        this(context,null);
    }

    public MorePersonalSettingItem(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MorePersonalSettingItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        String moreText = attrs.getAttributeValue(NAMESPACE,"moretext");
        Boolean isShowLine = attrs.getAttributeBooleanValue(NAMESPACE,"isShowLine",true);
        int moreicon = attrs.getAttributeResourceValue(NAMESPACE, "moreicon", R.drawable.ic_live_tiny);
        Boolean isShowToggle = attrs.getAttributeBooleanValue(NAMESPACE,"isShowToggle",false);

        initView();

        iv_more_icon.setImageResource(moreicon);
        tv_moretext.setText(moreText);

        if(isShowLine){
            iv_more_line.setVisibility(View.VISIBLE);
        } else {
            iv_more_line.setVisibility(View.INVISIBLE);
        }

        if(isShowToggle){
            switch_more.setVisibility(View.VISIBLE);
        } else {
            switch_more.setVisibility(View.INVISIBLE);
        }
    }

    public void initView(){
        View view = View.inflate(getContext(), R.layout.more_setting_item,null);
        iv_more_icon = (ImageView)view.findViewById(R.id.iv_more_icon);
        iv_more_line = (ImageView)view.findViewById(R.id.iv_more_line);
        tv_moretext = (TextView)view.findViewById(R.id.tv_moretext);
        switch_more = (Switch)view.findViewById(R.id.switch_more);
        addView(view);
    }


}
