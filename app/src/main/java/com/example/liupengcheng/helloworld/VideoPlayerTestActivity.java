package com.example.liupengcheng.helloworld;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.liupengcheng.helloworld.util.ToastUtil;

import java.io.File;

public class VideoPlayerTestActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnVideoPlay,mBtnVideoPause,mBtnVideoReplay;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_test);
        videoView = findViewById(R.id.video);
        mBtnVideoPlay = findViewById(R.id.btn_video_play);
        mBtnVideoPause = findViewById(R.id.btn_video_pause);
        mBtnVideoReplay = findViewById(R.id.btn_video_replay);
        mBtnVideoPlay.setOnClickListener(this);
        mBtnVideoPause.setOnClickListener(this);
        mBtnVideoReplay.setOnClickListener(this);
        if(ContextCompat.checkSelfPermission(VideoPlayerTestActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(VideoPlayerTestActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else{
            initVideoPath();//初始化
        }
    }

    private void initVideoPath(){
        File file = new File(Environment.getExternalStorageDirectory(),"whynot.mp4");
        videoView.setVideoPath(file.getPath());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    initVideoPath();
                }else {
                    ToastUtil.showMsg(VideoPlayerTestActivity.this,"拒绝权限将无法使用程序");
                    finish();
                }
                break;

            default:
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_video_play:
                //
                videoView.start();
                break;
            case R.id.btn_video_pause:
                //
                if (videoView.isPlaying()){
                    videoView.pause();
                }
                break;
            case R.id.btn_video_replay:
                //
                if (videoView.isPlaying()){
                    videoView.resume();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null){
            videoView.suspend();
        }
    }
}
