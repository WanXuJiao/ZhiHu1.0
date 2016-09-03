package com.example.zhihu10.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhihu10.MyApp;
import com.example.zhihu10.R;
import com.example.zhihu10.bean.Live;
import com.example.zhihu10.global.GlobalDatas;

import java.util.ArrayList;

/**
 * Created by Xu on 2016/8/25.
 */
public class FeedRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int NORMAL_ITEM = 0;
    private static final int LAST_ITEM = 1;
    private ArrayList<Live> lives = new ArrayList<Live>();

    @Override
    public int getItemViewType(int position) {
        if (position == lives.size()) {
            return LAST_ITEM;
        } else {
            return NORMAL_ITEM;
        }
    }

    public FeedRecycleViewAdapter(ArrayList<Live> lives) {
        this.lives = lives;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    //没有可用的item,创建新的ViewHolder
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == NORMAL_ITEM) {
            view = View.inflate(MyApp.getContext(), R.layout.item_recycleview, null);
            return new FeedViewHolder(view);
        } else {
            view = View.inflate(MyApp.getContext(), R.layout.item_recycleview_lastone, null);
            return new FeedLastViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FeedViewHolder) {
            bindFeedViewHolder((FeedViewHolder) holder, position);

        } else if(holder instanceof FeedLastViewHolder){
            bindFeedLastViewHolder((FeedLastViewHolder)holder);
        }
    }

    private void bindFeedLastViewHolder(FeedLastViewHolder holder) {
        holder.iv_last_one.setImageResource(R.drawable.ic_newrecord_finish);
        holder.tv_last_one.setText("查看所有Live");
    }

    private void bindFeedViewHolder(FeedViewHolder holder,final int position) {

        holder.iv_gridview_icon.setImageResource(lives.get(position).getIcon());
        holder.tv_gridView_givenname.setText(lives.get(position).getGivenName());
        holder.tv_gridView_title.setText(lives.get(position).getTitle());
        holder.tv_gridView_time.setText(lives.get(position).getTime());

        holder.ib_grid_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApp.getContext(),"删除当前条目",Toast.LENGTH_SHORT).show();
                //删除
                lives.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lives.size()+1;
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_gridview_icon;
        ImageButton ib_grid_close;
        TextView tv_gridView_title;
        TextView tv_gridView_givenname;
        TextView tv_gridView_time;

        public FeedViewHolder(View itemView) {
            super(itemView);
            iv_gridview_icon = (ImageView) itemView.findViewById(R.id.iv_gridview_icon);
            tv_gridView_title = (TextView) itemView.findViewById(R.id.tv_gridView_title);
            tv_gridView_givenname = (TextView) itemView.findViewById(R.id.tv_gridView_givenname);
            tv_gridView_time = (TextView) itemView.findViewById(R.id.tv_gridView_time);
            ib_grid_close = (ImageButton) itemView.findViewById(R.id.ib_grid_close);
        }
    }

    public class FeedLastViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_last_one;
        TextView tv_last_one;

        public FeedLastViewHolder(View itemView) {
            super(itemView);
            iv_last_one = (ImageView) itemView.findViewById(R.id.iv_last_one);
            tv_last_one = (TextView) itemView.findViewById(R.id.tv_last_one);
        }
    }
}
