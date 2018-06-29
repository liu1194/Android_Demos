package com.example.liupengcheng.helloworld;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTv4,mTv5;
    //1.聲明2.findbyid3.操作
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTv4 = findViewById(R.id.tv_4);
        mTv5 = findViewById(R.id.tv_5);
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
        mTv4.getPaint().setAntiAlias(true);//去除锯齿
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        mTv5.getPaint().setAntiAlias(true);
        //mTv5.setText(Html.fromHtml("<button>ssss</button>"));
    }
}
