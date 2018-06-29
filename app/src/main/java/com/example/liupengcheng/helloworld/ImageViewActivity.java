package com.example.liupengcheng.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIv_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv_2 = findViewById(R.id.iv_2);
        Glide.with(this).load("http://www.ahjzu.edu.cn/_upload/tpl/00/83/131/template131/images/top.jpg").into(mIv_2);
    }
}
