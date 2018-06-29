package com.example.liupengcheng.helloworld;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class NotificationTestActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnSendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);
        mBtnSendNotice = findViewById(R.id.send_notice);
        mBtnSendNotice.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.send_notice:
                Intent intent = new Intent(NotificationTestActivity.this,Main2Activity.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //manager.cancel(1);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("this is content title")
//                        .setContentText("this is content text")

                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(
                                BitmapFactory.decodeResource(getResources(),R.drawable
                                .ic_launcher_background)
                        ))
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pi)
                        //点击之后要跳转到哪里
                        .setAutoCancel(true)
                        //点击之后自动清除通知
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Journey.ogg")))
                        //设置通知铃声
                        .setVibrate(new long[] {0,1000,1000,1000})
                        //设置震动
                        .setLights(Color.GREEN,1000,1000)
                        //设置LED灯
                        //.setDefaults(NotificationCompat.DEFAULT_ALL)直接使用通知的默认效果
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(
                                "Learn how to build notifications,send and sync data," +
                                        "and use voice actions.Get the official Android IDE " +
                                        "and developer tools  to build app for Android."))
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();
                manager.notify(1,notification);
                break;
            default:
                break;
        }

    }
}
