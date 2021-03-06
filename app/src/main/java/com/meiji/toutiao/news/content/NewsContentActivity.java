package com.meiji.toutiao.news.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.meiji.toutiao.InitApp;
import com.meiji.toutiao.R;
import com.meiji.toutiao.bean.news.NewsArticleBean;

/**
 * Created by Meiji on 2017/2/28.
 */

public class NewsContentActivity extends AppCompatActivity {

    public static final String TAG = "NewsContentActivity";

    public static void startActivity(NewsArticleBean.DataBean bean) {
        InitApp.AppContext.startActivity(new Intent(InitApp.AppContext, NewsContentActivity.class)
                .putExtra(NewsContentActivity.TAG, bean)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        NewsContentFragment newsContentFragment = NewsContentFragment.newInstance(getIntent().getParcelableExtra(TAG));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, newsContentFragment)
                .commit();
    }
}
