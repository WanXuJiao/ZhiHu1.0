package com.example.zhihu10.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.zhihu10.R;

/**
 * Created by Xu on 2016/8/30.
 */
public class MyCollectActivity extends AppCompatActivity {

    private ImageView iv_my_collect_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);

        initView();
    }

    private void initView() {
        iv_my_collect_back = (ImageView)findViewById(R.id.iv_my_collect_back);

        iv_my_collect_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
