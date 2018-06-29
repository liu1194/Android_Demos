package com.example.liupengcheng.helloworld;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.liupengcheng.helloworld.util.ToastUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileActivity extends AppCompatActivity {

    private EditText edit,display;
    private Button mBtnSave,mBtnLoad,mBtnClean,mBtnSPSave,mBtnDisplaySP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        mBtnSave = findViewById(R.id.btn_save);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit = findViewById(R.id.file_edit);
                String inputText = edit.getText().toString();
                save(inputText);
                ToastUtil.showMsg(FileActivity.this,"save succeeded!");
            }
        });
        mBtnLoad = findViewById(R.id.display);
        mBtnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display = findViewById(R.id.file_edit_display);
                String inputText = load();
                if(!TextUtils.isEmpty(inputText)){
                    display.setText(inputText);
                    display.setSelection(inputText.length());
                    ToastUtil.showMsg(FileActivity.this,"Display succeeded!");
                }
            }
        });
        mBtnClean = findViewById(R.id.clean_all);
        mBtnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
                ToastUtil.showMsg(FileActivity.this,"Clean Succeeded!");
            }
        });
        mBtnSPSave = findViewById(R.id.btn_save_sp);
        mBtnSPSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //保存SharedPreferences内容
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","tom");
                editor.putInt("age",22);
                editor.putBoolean("married",false);
                editor.apply(); //put数据最后用apply()提交
            }
        });
        mBtnDisplaySP = findViewById(R.id.display_sp);
        mBtnDisplaySP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示SharedPreferences内容
                SharedPreferences preferences =  getSharedPreferences("data",MODE_PRIVATE);
                String name = preferences.getString("name","");
                int age = preferences.getInt("age",0);
                boolean married = preferences.getBoolean("married",false);
                Log.d("FileActivity","name is "+name);

            }
        });

    }

//    @Override
//    protected void onDestroy() {  //在活动销毁时调用save()方法保存EditText中输入的内容到文件中
//        super.onDestroy();
//        String inputText = edit.getText().toString();
//        ToastUtil.showMsg(FileActivity.this,"save success!");
//        save(inputText);
//    }

// （1）通过openFileOutput()方法得到一个FileOutputStream对象
// （2）借助FileOutputStream对象构建一个OutputStreamWriter对象
// （3）使用OutputStreamWritwer构建一个BufferedWriter对象
// （4）通过BufferedWriter将文本内容写入到文件里

    public void save(String inputText){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
            out = openFileOutput("data.txt",Context.MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(writer != null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

//  (1)通过openFileInput()方法获取到一个FileInputStream对象
//  (2)借助FileInputStream对象构建InputStreamReader对象
//  (3)使用InptuStreamReader构建一个BufferedReader对象
//  (4)通过BufferedReader进行一行一行的读取
//  (5)把文件的所有内容读取出来，并存放到一个StringBuilder对象中
//  (6)将读取到的内容返回

    public String load(){
        FileInputStream in =null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            in = openFileInput("data.txt");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line = reader.readLine()) != null){
                content.append(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
