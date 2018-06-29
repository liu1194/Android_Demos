

package com.example.liupengcheng.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceTestActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        Button startService = findViewById(R.id.start_service);
        Button stopService = findViewById(R.id.stop_service);
        Button startIntentService = findViewById(R.id.start_intent_service);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        startIntentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_service:
                //start service
                Intent startIntent = new Intent(ServiceTestActivity.this,MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_service:
                //stop service
                Intent stopIntent = new Intent(ServiceTestActivity.this,MyService.class);
                stopService(stopIntent);
                break;
            case R.id.start_intent_service:
                //打印主线程的ID
                Log.d("ServiceTestActivity","Thread id is "+Thread.currentThread().getId());
                Intent startIntentService = new Intent(ServiceTestActivity.this,MyIntentService.class);
                startService(startIntentService);
                break;
            default:
                break;
        }
    }

}
