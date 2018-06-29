package com.example.liupengcheng.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liupengcheng.helloworld.util.ToastUtil;
import com.example.liupengcheng.helloworld.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnCustomDialog = findViewById(R.id.btn_cusdialog);
        mBtnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("title").setMessage("are you comform?")
                   .setCancel("cancel", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog customDialog) {
                        //
                        ToastUtil.showMsg(CustomDialogActivity.this,"aaa");
                    }
                }).setConfirm("confirm", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog customDialog) {
                        //
                        ToastUtil.showMsg(CustomDialogActivity.this,"bbb");
                    }
                }).show();
            }
        });
    }
}
