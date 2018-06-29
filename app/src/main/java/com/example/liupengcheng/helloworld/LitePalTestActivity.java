package com.example.liupengcheng.helloworld;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.liupengcheng.helloworld.util.ToastUtil;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class LitePalTestActivity extends AppCompatActivity {

    private Button mBtnCreateDatabase_litepal,mBtnAddData,mBtnUpdateData,mBtnDeleteData,mBtnQuery;
    private ListView litepal_view;
    List<String> litepal_list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal_test);
        mBtnCreateDatabase_litepal = findViewById(R.id.btn_create_database_lp);
        mBtnCreateDatabase_litepal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
                ToastUtil.showMsg(LitePalTestActivity.this,"LitePal!");
            }
        });

        mBtnAddData = findViewById(R.id.btn_add_data_lp);
        mBtnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(19.96);
                book.save();
            }
        });

        mBtnUpdateData = findViewById(R.id.btn_update_data_lp);
        mBtnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
//              book.setName("The Da Vinci Code");
//              book.setAuthor("Dan Brown");
//              book.setPages(454);
//              book.setPrice(19.96);
//              book.save();
//              book.setPrice(10.96);
//              book.save();
                book.setPrice(10.99);
                //更新限制条件下的数据
                book.updateAll("name = ? and author = ?","The Da Vinci Code","Dan Brown");

                //将所有书的页数都设置成默认(0)
//              book.setToDefault("pages");
//              book.updateAll();
            }
        });

        mBtnDeleteData = findViewById(R.id.btn_delete_data_lp);
        mBtnDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.deleteAll(Book.class,"pages < ?","15");
            }
        });

        mBtnQuery = findViewById(R.id.btn_query_data_lp);
        mBtnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book> books = LitePal.findAll(Book.class);
//                Book firstbook = LitePal.findFirst(Book.class);
//                Book lastbook = LitePal.findLast(Book.class);
                //查找第一条或最后一条记录
//                List<Book> books1 = LitePal.select("name").find(Book.class);
                //只查name这列数据
//                List<Book> books1 = LitePal.where("pages > ?","50").find(Book.class);
                //where用于指定查询条件
//                List<Book> books1 = LitePal.order("pages desc").find(Book.class);
                //order()用于按照指定的列排序
//                List<Book> books1 = LitePal.limit(3).find(Book.class);
                //limit(n)只查表中的前n条数据
//                List<Book> books1 = LitePal.limit(3).offset(1).find(Book.class);
                //offset(n)设置n位的偏移量
//                Cursor c = LitePal.findBySQL("select * from book where pages > ? and price > ?","50","10");
                //LitePal同时支持SQL原生语句查询，findBySQL()返回的是一个Cursor类型
                for(Book book:books){
                    Log.d("LitePalTestActivity","name is "+book.getName());
                    Log.d("LitePalTestActivity","author is "+book.getAuthor());
                    Log.d("LitePalTestActivity","pages is "+book.getPages());
                    Log.d("LitePalTestActivity","price is "+book.getPrice());
                }
            }
        });
    }

}
