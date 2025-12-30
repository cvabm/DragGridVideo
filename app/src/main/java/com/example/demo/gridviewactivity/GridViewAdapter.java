package com.example.demo.gridviewactivity;


import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.demo.R;
import com.example.demo.VideoBean;
import com.example.demo.gridview.scrollrunner.OnItemMovedListener;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter implements OnItemMovedListener {
    private Context context;
    private List<VideoBean> mDatas = new ArrayList<>(); // 这里存视频 URL 字符串

    public GridViewAdapter(Context context, List<VideoBean> dataList) {
        this.context = context;
        this.mDatas.addAll(dataList);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public VideoBean getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout item_rl;
        VideoView videoView;
        TextView videoName;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.video_item, parent, false);
            item_rl = convertView.findViewById(R.id.item_rl);
            videoView = convertView.findViewById(R.id.videoView);
            videoName = convertView.findViewById(R.id.videoName);
            convertView.setTag(R.id.tag_video_initialized, false);
            convertView.setTag(R.id.tag_video_rl, item_rl);
            convertView.setTag(R.id.tag_video_view, videoView);
            convertView.setTag(R.id.tag_video_name, videoName);
        } else {
            item_rl = (RelativeLayout) convertView.getTag(R.id.tag_video_rl);
            videoView = (VideoView) convertView.getTag(R.id.tag_video_view);
            videoName = (TextView) convertView.getTag(R.id.tag_video_name);
        }

        Boolean initialized = (Boolean) videoView.getTag(R.id.tag_video_initialized);
        if (initialized == null) {
            initialized = false;
        }

        if (!initialized) {
            int itemSize = DensityUtil.dip2px(context, 200);
            int screenHeight = context.getResources().getDisplayMetrics().heightPixels;

            GridView.LayoutParams params = new GridView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, screenHeight / 4);
            item_rl.setLayoutParams(params);
            String videoUrl = getItem(position).url;
            String name = getItem(position).name;
            videoName.setText(name);
            videoView.setVideoURI(Uri.parse(videoUrl));
            videoView.setOnPreparedListener(mp -> {
                mp.setLooping(true);     // 循环播放
                mp.setVolume(0f, 0f);    // 静音
                videoView.start();
            });

            videoView.setOnErrorListener((mp, what, extra) -> true);
            videoView.setTag(R.id.tag_video_initialized, true);
        }
        return convertView;
    }

    @Override
    public void onItemMoved(int from, int to) {
    }

    @Override
    public boolean isFixed(int position) {
        return false;
    }
}