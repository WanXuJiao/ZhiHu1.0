package com.example.zhihu10.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhihu10.MainActivity;
import com.example.zhihu10.R;

/**
 * Created by Xu on 2016/8/31.
 */
public class LogInActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout ll_log_in;
    private LinearLayout ll_log_in_share_id;
    private LinearLayout ll_register;
    private ImageView iv_log_in_see_password;
    private ImageView iv_register_see_password;
    private TextView tv_swicth_long_in_register;
    private EditText et_register_phone_number;
    private EditText et_register_password;
    private EditText et_log_in_phone_number;
    private EditText et_log_in_password;
    private EditText et_log_in_name;
    private Button btn_register;
    private TextView tv_log_in_tell_rull;
    private AlphaAnimation alphaAnimation;
    private TranslateAnimation translateAnimation;
    private TranslateAnimation preIn;
    private TranslateAnimation preOut;
    private TranslateAnimation nextIn;
    private TranslateAnimation nextOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        initView();
        initAnimation();
    }

    private void initView() {
        ll_log_in = (LinearLayout)findViewById(R.id.ll_log_in);
        ll_log_in_share_id = (LinearLayout)findViewById(R.id.ll_log_in_share_id);
        ll_register = (LinearLayout)findViewById(R.id.ll_register);

        iv_log_in_see_password = (ImageView)findViewById(R.id.iv_log_in_see_password);
        iv_register_see_password = (ImageView)findViewById(R.id.iv_register_see_password);

        tv_swicth_long_in_register = (TextView)findViewById(R.id.tv_swicth_long_in_register);
        tv_log_in_tell_rull = (TextView)findViewById(R.id.tv_log_in_tell_rull);

        btn_register = (Button) findViewById(R.id.btn_register);

        et_register_phone_number = (EditText)findViewById(R.id.et_register_phone_number);
        et_register_password = (EditText)findViewById(R.id.et_register_password);
        et_log_in_phone_number = (EditText)findViewById(R.id.et_log_in_phone_number);
        et_log_in_password = (EditText)findViewById(R.id.et_log_in_password);
        et_log_in_name = (EditText)findViewById(R.id.et_log_in_name);

        btn_register.setOnClickListener(this);
        tv_swicth_long_in_register.setOnClickListener(this);
    }

    private void initAnimation() {
        alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(true);

        preIn = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.pre_in);
        preOut = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.pre_out);
        nextIn = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.next_in);
        nextOut = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.next_out);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.tv_swicth_long_in_register:
                if(btn_register.getText().equals("登录")){
                    ll_register.clearAnimation();
                    ll_log_in.clearAnimation();
                    btn_register.setText("注册");
                    ll_log_in_share_id.setVisibility(View.GONE);
                    tv_log_in_tell_rull.setVisibility(View.VISIBLE);
                    tv_swicth_long_in_register.setText("已有知乎账号?去登陆");
                    ll_register.setVisibility(View.VISIBLE);
                    ll_register.startAnimation(nextIn);
                    ll_log_in.startAnimation(nextOut);
                    ll_log_in.setVisibility(View.GONE);
                } else {
                    ll_register.clearAnimation();
                    ll_log_in.clearAnimation();
                    btn_register.setText("登录");
                    tv_log_in_tell_rull.setVisibility(View.GONE);
                    tv_swicth_long_in_register.setText("没有知乎账号?去注册");
                    ll_log_in_share_id.setVisibility(View.VISIBLE);
                    ll_log_in_share_id.startAnimation(alphaAnimation);
                    ll_log_in.setVisibility(View.VISIBLE);
                    ll_register.startAnimation(preOut);
                    ll_log_in.startAnimation(preIn);
                    ll_register.setVisibility(View.GONE);

                }

                break;
        }
    }
}
