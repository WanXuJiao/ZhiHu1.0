package com.example.zhihu10.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.zhihu10.MyApp;
import com.example.zhihu10.R;
import com.example.zhihu10.global.GlobalDatas;

/**
 * Created by Xu on 2016/8/30.
 */
public class ConcernCollectAdapter extends BaseAdapter {
    private int layout;

    public ConcernCollectAdapter(int layout) {
        this.layout = layout;

    }

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
            view = View.inflate(MyApp.getContext(), layout, null);
        } else {
            view = convertView;
        }
        switch (layout) {
            case R.layout.item_concern_question_listview:
                TextView tv_concern_question_title = (TextView) view.findViewById(R.id.tv_concern_question_title);
                TextView tv_concern_question_answer_count = (TextView) view.findViewById(R.id.tv_concern_question_answer_count);
                TextView tv_concern_question_concern_count = (TextView) view.findViewById(R.id.tv_concern_question_concern_count);

                tv_concern_question_title.setText(GlobalDatas.mConcernQuestionTitles[position]);
                tv_concern_question_answer_count.setText(GlobalDatas.mConcernQuestionAnswers[position]+"个回答");
                tv_concern_question_concern_count.setText(GlobalDatas.mConcernQuestionConcerns[position]+"人关注");
                break;
            case R.layout.item_concern_topic_listview:
                ImageView civ_concern_topic_icon = (ImageView)view.findViewById(R.id.civ_concern_topic_icon);
                TextView tv_concern_topic_title = (TextView) view.findViewById(R.id.tv_concern_topic_title);
                TextView tv_concern_topic_content = (TextView) view.findViewById(R.id.tv_concern_topic_content);

                civ_concern_topic_icon.setImageResource(GlobalDatas.mConcernTopicIcons[position]);
                tv_concern_topic_title.setText(GlobalDatas.mConcernTopicAnswers[position]);
                tv_concern_topic_content.setText(GlobalDatas.mConcernTopicConcerns[position]);
                break;
            case R.layout.item_concern_column_listview:
                ImageView civ_concern_column_icon = (ImageView)view.findViewById(R.id.civ_concern_column_icon);
                TextView tv_concern_column_title = (TextView) view.findViewById(R.id.tv_concern_column_title);
                TextView tv_concern_column_showword = (TextView) view.findViewById(R.id.tv_concern_column_showword);
                TextView tv_concern_column_concern = (TextView) view.findViewById(R.id.tv_concern_column_concern);
                TextView tv_concern_column_wenzhang = (TextView) view.findViewById(R.id.tv_concern_column_wenzhang);

                civ_concern_column_icon.setImageResource(GlobalDatas.mConcernColumnIcons[position]);
                tv_concern_column_title.setText(GlobalDatas.mConcernColumnAnswers[position]);
                tv_concern_column_showword.setText(GlobalDatas.mConcernColumnConcerns[position]);
                tv_concern_column_concern.setText(GlobalDatas.mConcernQuestionAnswers[position]+"篇文章");
                tv_concern_column_wenzhang.setText(GlobalDatas.mConcernQuestionConcerns[position]+"人关注");
                break;
            case R.layout.item_concern_user_listview:
                ImageView civ_concern_user_icon = (ImageView)view.findViewById(R.id.civ_concern_user_icon);
                TextView tv_concern_user_name = (TextView) view.findViewById(R.id.tv_concern_user_name);
                TextView tv_concern_user_showword = (TextView) view.findViewById(R.id.tv_concern_user_showword);

                civ_concern_user_icon.setImageResource(GlobalDatas.mConcernColumnIcons[position]);
                tv_concern_user_name.setText(GlobalDatas.mConcernUserNames[position]);
                tv_concern_user_showword.setText(GlobalDatas.mConcernUserShowWords[position]);
                break;

            default:
                break;
        }

        return view;
    }
}
