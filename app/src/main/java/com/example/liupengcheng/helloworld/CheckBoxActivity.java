package com.example.liupengcheng.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private Switch mSwitch;
    private CheckBox mCbox_1,mCbox_2,mCbox_3,mCbox_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mCbox_1 = findViewById(R.id.checkbox_1);
        mCbox_2 = findViewById(R.id.checkbox_2);
        mCbox_3 = findViewById(R.id.checkbox_3);
        mCbox_4 = findViewById(R.id.checkbox_4);
        mSwitch = findViewById(R.id.sw_1);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(mCbox_1.isChecked()){
                    Toast.makeText(CheckBoxActivity.this,"mbox_1 select!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
