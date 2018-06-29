package com.example.liupengcheng.helloworld;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liupengcheng.helloworld.fragment.AnotherRightFragment;
import com.example.liupengcheng.helloworld.fragment.RightFragment;
import com.example.liupengcheng.helloworld.util.ToastUtil;


public class FragmentTestActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        Button button = findViewById(R.id.btn_left_fragment);
        button.setOnClickListener(this);
        //replaceFragment(new RightFragment());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_left_fragment:
                replaceFragment(new AnotherRightFragment());
                break;
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_fragment,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
