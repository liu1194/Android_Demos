package com.example.liupengcheng.helloworld.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.liupengcheng.helloworld.R;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context,String newsTitle,String newsContent){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("newsTitle",newsTitle).putExtra("newsContent",newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        String newsTilte = getIntent().getStringExtra("newsTitle"); //获取传入的新闻标题
        String newsContent = getIntent().getStringExtra("newsContent");//获取传入的新闻内容
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTilte,newsContent);//刷新NewsContentFragment界面
    }
}
