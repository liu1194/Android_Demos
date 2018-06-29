package com.example.liupengcheng.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.liupengcheng.helloworld.fragmentbestpractice.FragBestPracticeActivity;

import java.io.InputStream;

public class Main2Activity extends AppCompatActivity {

    private Button mBtn_activity,mBtn_fragment,mBtnBestPractice,mBtnFileOption,mBtnLoginPractice,
            mBtmDatabase,mBtnLitePalTest,mBtnPermissionTest,mBtnNotificationTest,mBtnCameraAlbumTest,
            mBtnContact,mBtnMedia,mBtnNetwork,mBtnThreadTest,mBtnService,mBtnDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mBtn_activity = findViewById(R.id.btn_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBtn_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mBtn_fragment = findViewById(R.id.btn_fragment);
        mBtn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,FragmentTestActivity.class);
                startActivity(intent);
            }
        });
        mBtnBestPractice = findViewById(R.id.btn_bestfragment);
        mBtnBestPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,FragBestPracticeActivity.class);
                startActivity(intent);
            }
        });
        mBtnFileOption = findViewById(R.id.btn_file);
        mBtnFileOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,FileActivity.class);
                startActivity(intent);
            }
        });
        mBtnLoginPractice = findViewById(R.id.btn_login_practice);
        mBtnLoginPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,LoginPracticeActivity.class);
                startActivity(intent);
            }
        });
        mBtmDatabase = findViewById(R.id.btn_database);
        mBtmDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,DatabaseTestActivity.class);
                startActivity(intent);
            }
        });
        mBtnLitePalTest = findViewById(R.id.btn_LitePal);
        mBtnLitePalTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,LitePalTestActivity.class);
                startActivity(intent);
            }
        });
        mBtnPermissionTest = findViewById(R.id.btn_permission_test);
        mBtnPermissionTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,PermissionTestActivity.class);
                startActivity(intent);
            }
        });
        mBtnNotificationTest = findViewById(R.id.btn_notification_test);
        mBtnNotificationTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,NotificationTestActivity.class);
                startActivity(intent);
            }
        });
        mBtnCameraAlbumTest = findViewById(R.id.btn_camera_test);
        mBtnCameraAlbumTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,CameraAlbumActivity.class);
                startActivity(intent);
            }
        });
        mBtnContact = findViewById(R.id.btn_contact_test);
        mBtnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,ContactTestActivity.class);
                startActivity(intent);
            }
        });
        mBtnMedia = findViewById(R.id.btn_media_test);
        mBtnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MediaActivity.class);
                startActivity(intent);
            }
        });
        mBtnNetwork = findViewById(R.id.btn_network_test);
        mBtnNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,NetworkTestActivity.class);
                startActivity(intent);
            }
        });
        mBtnThreadTest = findViewById(R.id.btn_thread_test);
        mBtnThreadTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,ThreadTestActivity.class);
                startActivity(intent);
            }
        });
        mBtnService = findViewById(R.id.btn_service_test);
        mBtnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,ServiceTestActivity.class);
                startActivity(intent);
            }
        });
        mBtnDrawer = findViewById(R.id.btn_drawer_test);
        mBtnDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,DrawerTestActivity.class);
                startActivity(intent);
            }
        });

    }
}
