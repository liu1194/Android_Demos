package com.example.liupengcheng.helloworld;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.liupengcheng.helloworld.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4,mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1 = findViewById(R.id.btn_dialog1);
        mBtnDialog2 = findViewById(R.id.btn_dialog2);
        mBtnDialog3 = findViewById(R.id.btn_dialog3);
        mBtnDialog4 = findViewById(R.id.btn_dialog4);
        mBtnDialog5 = findViewById(R.id.btn_dialog5);
        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("Please Answer").setMessage("How about this?")
                            .setIcon(R.drawable.icon_password)
                            .setPositiveButton("good", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(getApplicationContext(),"you are honist");
                                }
                            }).setNeutralButton("just so so", new DialogInterface.OnClickListener() {
                        @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(getApplicationContext(),"see again");
                                }
                            }).setNegativeButton("bad", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(getApplicationContext(),"you are a lier");
                                }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array = new String[]{"Male","Female"};
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                    builder1.setTitle("Choose Genger").setItems(array, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(getApplicationContext(),array[i]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array2 = new String[]{"Male","Female"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("Choose Gender").setSingleChoiceItems(array2, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(getApplicationContext(),array2[i]);
                            dialogInterface.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] array3 = new String[]{"Singing","Dancing","Coding"};
                    final boolean[] isSelected = new boolean[]{false,false,true};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("Choose a habit").setMultiChoiceItems(array3, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            ToastUtil.showMsg(getApplicationContext(),array3[i]+":"+b);
                        }
                    }).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //
                        }
                    }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //
                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view5 = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog,null);
                    final EditText etUserName = view5.findViewById(R.id.et_dialog_username);
                    final EditText etPassWord = view5.findViewById(R.id.et_dialog_password);
                    Button mBtnLogin = view5.findViewById(R.id.btn_dialog_login);
                    mBtnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //login
                            String username,password;
                            username = etUserName.toString();
                            password =etPassWord.toString();
                            if(username == "lpc" && password == "123"){
                                ToastUtil.showMsg(DialogActivity.this,"Login Success!");
                            }else{
                                ToastUtil.showMsg(DialogActivity.this,"Error!");
                            }
                        }
                    });
                    builder5.setTitle("PLEASE LOGIN").setView(view5).show();
                    break;
            }
        }
    }
}
