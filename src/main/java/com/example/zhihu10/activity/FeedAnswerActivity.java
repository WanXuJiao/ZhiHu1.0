package com.example.zhihu10.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zhihu10.R;

/**
 * Created by Xu on 2016/8/22.
 */
public class FeedAnswerActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView iv_answer_turnback;
    private Toolbar answer_toolbar;
    private ImageView iv_answer_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_answer_content);
        initView();
        setSupportActionBar(answer_toolbar);

    }

    private void initView() {
        iv_answer_turnback = (ImageView) findViewById(R.id.iv_answer_turnback);
        answer_toolbar = (Toolbar)findViewById(R.id.answer_toolbar);
        iv_answer_share = (ImageView)findViewById(R.id.iv_answer_share);

        iv_answer_share.setOnClickListener(this);
        iv_answer_turnback.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feed_answer,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.answer_font_size:
                Toast.makeText(getApplicationContext(),"字体大小",Toast.LENGTH_SHORT).show();
                break;
            case R.id.answer_hidename:
                Toast.makeText(getApplicationContext(),"使用匿名身份",Toast.LENGTH_SHORT).show();
                break;
            case R.id.answer_tip:
                Toast.makeText(getApplicationContext(),"举报",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_answer_share:
                Toast.makeText(getApplicationContext(),"share",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_answer_turnback:
                finish();
                break;
        }
    }
}
