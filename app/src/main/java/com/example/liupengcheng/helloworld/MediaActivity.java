package com.example.liupengcheng.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MediaActivity extends AppCompatActivity {

    private Button mBtnMusic,mBtnVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        mBtnMusic = findViewById(R.id.btn_music_test);
        mBtnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaActivity.this,MusicPlayerTestActivity.class);
                startActivity(intent);
            }
        });
        mBtnVideo = findViewById(R.id.btn_video_test);
        mBtnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaActivity.this,VideoPlayerTestActivity.class);
                startActivity(intent);
            }
        });
    }
}
