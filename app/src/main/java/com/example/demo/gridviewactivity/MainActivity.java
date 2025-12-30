package com.example.demo.gridviewactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.demo.R;
import com.example.demo.VideoBean;
import com.example.demo.gridview.HandyGridView;
import com.example.demo.gridview.listener.OnItemCapturedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private HandyGridView mGridView;
    private List<VideoBean> strList;
    private GridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_bottom_drag_layout);
        initData();
        initView();
    }

    private void initView() {
        mGridView = findViewById(R.id.grid_tips);
        adapter = new GridViewAdapter(this, strList);
        mGridView.setAdapter(adapter);
        mGridView.setNumColumns(3);
        mGridView.setOnItemCapturedListener(new OnItemCapturedListener() {
            @Override
            public void onItemCaptured(View v, int position) {
                v.setScaleX(1.2f);
                v.setScaleY(1.2f);
            }

            @Override
            public void onItemReleased(View v, int position) {
                v.setScaleX(1f);
                v.setScaleY(1f);
            }

        });
    }

    public void initData() {
        strList = new ArrayList<>();
        strList.add(new VideoBean("名称1", "https://stream7.iqilu.com/10339/upload_transcode/202002/09/20200209105011F0zPoYzHry.mp4"));
        strList.add(new VideoBean("名称2", "https://stream7.iqilu.com/10339/upload_transcode/202002/09/20200209105011F0zPoYzHry.mp4"));
        strList.add(new VideoBean("名称3", "https://stream7.iqilu.com/10339/upload_transcode/202002/09/20200209105011F0zPoYzHry.mp4"));
        strList.add(new VideoBean("名称4", "https://stream7.iqilu.com/10339/upload_transcode/202002/09/20200209105011F0zPoYzHry.mp4"));
        strList.add(new VideoBean("名称5", "https://stream7.iqilu.com/10339/upload_transcode/202002/09/20200209105011F0zPoYzHry.mp4"));
        strList.add(new VideoBean("名称6", "https://sf1-cdn-tos.huoshanstatic.com/obj/media-fe/xgplayer_doc_video/mp4/xgplayer-demo-360p.mp4"));
        strList.add(new VideoBean("名称7", "https://media.w3.org/2010/05/sintel/trailer.mp4"));
        strList.add(new VideoBean("名称8", "https://stream7.iqilu.com/10339/upload_transcode/202002/09/20200209104902N3v5Vpxuvb.mp4"));
        strList.add(new VideoBean("名称9", "https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8"));
    }

}
