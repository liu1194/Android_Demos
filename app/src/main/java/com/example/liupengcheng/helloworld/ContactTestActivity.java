package com.example.liupengcheng.helloworld;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.liupengcheng.helloworld.util.ToastUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactTestActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    List<String> contacts_list = new ArrayList<>();
    private ListView contact_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_test);

        contact_view = findViewById(R.id.contacts_view);
        adapter = new ArrayAdapter<String>(ContactTestActivity.this,
                android.R.layout.simple_list_item_1,contacts_list );
        contact_view.setAdapter(adapter);

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);

        }else {
            readContacts();
        }
    }

    private void readContacts(){
        Cursor cursor =null;
        try {
            //search contacts' data
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.
                    Phone.CONTENT_URI, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()){
                    //get contact's name
                    String displayName = cursor.getString(cursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    //get contact's Phone number
                    String number = cursor.getString(cursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER));
                    contacts_list.add(displayName + "\n" + number);
                }
                adapter.notifyDataSetChanged();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (cursor != null){
                cursor.close();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    readContacts();
                }else {
                    ToastUtil.showMsg(ContactTestActivity.this,"You denied the permission");
                }
                break;
            default:
        }
    }
}
