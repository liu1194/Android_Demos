package com.example.liupengcheng.helloworld;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThreadTestActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnChangeText;
    private TextView ThreadText;
    public static final int UPDATE_TEXT = 1;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    //这里可以进行UI操作
                    ThreadText.setText("Nice to see you");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);
        mBtnChangeText = findViewById(R.id.btn_change_text);
        ThreadText = findViewById(R.id.thread_text);
        mBtnChangeText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);//将Message对象发送出去
                    }
                }).start();
                break;

            default:
                break;
        }
    }
}
