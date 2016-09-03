package com.example.zhihu10.base.pager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zhihu10.MyApp;
import com.example.zhihu10.R;
import com.example.zhihu10.activity.FeedAnswerActivity;
import com.example.zhihu10.adapter.FeedRecycleViewAdapter;
import com.example.zhihu10.base.BasePager;
import com.example.zhihu10.bean.Live;
import com.example.zhihu10.global.GlobalDatas;

import java.util.ArrayList;

/**
 * Created by Xu on 2016/8/20.
 */
public class FeedPager extends BasePager implements View.OnClickListener {

    private ListView lv_feed;
    //private SwipeRefreshLayout srl_feed_listview;
    private ImageButton iv_live_tiny;
    private ArrayList<Live> lives ;
    //private FloatingActionButton fab_discover;

    /*private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    srl_feed_listview.setRefreshing(false);
                    break;
                default:
                    break;
            }
        }
    };*/

    public FeedPager(Activity mActivity) {

        super(mActivity);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_feed, null);
        lv_feed = (ListView) view.findViewById(R.id.lv_feed);
        //srl_feed_listview = (SwipeRefreshLayout) view.findViewById(R.id.srl_feed_listview);
        iv_live_tiny = (ImageButton) view.findViewById(R.id.iv_live_tiny);
        //fab_discover = (FloatingActionButton) view.findViewById(R.id.fab_discover);

        //srl_feed_listview.setColorSchemeColors(Color.BLUE);

        lv_feed.setAdapter(new FeedAdapter( ));
        initListener();
        return view;
    }

    //加载监听器
    private void initListener() {
        lv_feed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MyApp.getContext(), FeedAnswerActivity.class);
                if (position != 1) {
                    mActivity.startActivity(intent);
                }
            }
        });

        /*srl_feed_listview.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(1);
                    }
                }).start();
            }
        });*/

        iv_live_tiny.setOnClickListener(this);
        //fab_discover.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_live_tiny:
                Toast.makeText(MyApp.getContext(), "全部Live", Toast.LENGTH_SHORT).show();
                break;
            /*case R.id.fab_discover:
                Toast.makeText(MyApp.getContext(), "我是萌萌哒浮动按钮", Toast.LENGTH_SHORT).show();
                break;*/
        }
    }

    private class FeedAdapter extends BaseAdapter {

        private PopupMenu mPopupMenu;

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
            if (position == 1) {
                //添加RecycleView,横向单行可滑动
                view = View.inflate(MyApp.getContext(), R.layout.item_listview_feed_recycleview, null);
                RecyclerView recycler_feed = (RecyclerView) view.findViewById(R.id.recycler_feed);
                final ImageButton ib_feed_recycleview = (ImageButton) view.findViewById(R.id.ib_feed_recycleview);
                //设置布局管理器
                LinearLayoutManager layout = new LinearLayoutManager(MyApp.getContext());
                layout.setOrientation(LinearLayoutManager.HORIZONTAL);

                recycler_feed.setLayoutManager(layout);

                lives= new ArrayList<Live>();
                for(int i=0;i<GlobalDatas.mRecycleViewIcons.length;i++){
                    Live live = new Live();
                    live.setIcon(GlobalDatas.mRecycleViewIcons[i]);
                    live.setGivenName(GlobalDatas.mRecycleViewGivenName[i]);
                    live.setTime(GlobalDatas.mRecycleViewTimes[i]);
                    live.setTitle(GlobalDatas.mRecycleViewTitles[i]);
                    lives.add(live);
                }
                //设置适配器
                FeedRecycleViewAdapter adapter = new FeedRecycleViewAdapter(lives);
                recycler_feed.setAdapter(adapter);

                ib_feed_recycleview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showPopupMenu(ib_feed_recycleview, R.menu.menu_feed_list_item_last_menu);
                    }
                });
            } else {
                view = View.inflate(MyApp.getContext(), R.layout.item_listview_feed, null);
                final ImageButton ib_feed_listview_menu = (ImageButton) view.findViewById(R.id.ib_feed_listview_menu);
                ib_feed_listview_menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showPopupMenu(ib_feed_listview_menu, R.menu.menu_feed_list_item_menu);
                    }
                });
            }

            return view;
        }

        private void showPopupMenu(View view, int myMenu) {
            mPopupMenu = new PopupMenu(mActivity, view);
            mPopupMenu.getMenuInflater().inflate(myMenu, mPopupMenu.getMenu());
            mPopupMenu.show();

            mPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_nofeel:
                            Toast.makeText(MyApp.getContext(), "不感兴趣", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.action_share:
                            Toast.makeText(MyApp.getContext(), "分享", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.action_nofeel_live:
                            Toast.makeText(MyApp.getContext(), "对知乎Live不感兴趣", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.action_what:
                            Toast.makeText(MyApp.getContext(), "什么是知乎Live?", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
        }

    }
}
