package com.example.liupengcheng.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button mBtn_3;
    private TextView mtv_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mBtn_3 = findViewById(R.id.btn_3);
        mBtn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //btn3点击事件
                Toast.makeText(ButtonActivity.this, "btn_3 is onClicking!", Toast.LENGTH_SHORT).show();
            }
        });
        mtv_1 = findViewById(R.id.tv_btn);//返回View类型
        mtv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"tv_btn is onClicking!",Toast.LENGTH_SHORT);
            }
        });
    }
    public void showToast(View view){
        Toast.makeText(this,"i am Clicking!",Toast.LENGTH_SHORT).show();
    }
}
