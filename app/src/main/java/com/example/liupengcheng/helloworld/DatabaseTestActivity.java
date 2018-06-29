package com.example.liupengcheng.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.liupengcheng.helloworld.util.ToastUtil;

public class DatabaseTestActivity extends AppCompatActivity {

    private Button mBtnCteateDAtabase,mBtnAddData,mBtnUpdataData,mBtnDeleteData,mBtnQueryData;
    private MyDatabaseHelper dbHelper;
    private TextView text_name,text_author,text_pages,text_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test);
        //
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
        mBtnCteateDAtabase = findViewById(R.id.btn_create_database);
        mBtnCteateDAtabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();//创建数据库
            }
        });
        mBtnAddData = findViewById(R.id.btn_add_data);
        mBtnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name","The Da Vinci Code");
                values.put("author","Dan Brown");
                values.put("pages","454");
                values.put("price","19.96");
                db.insert("Book",null,values);
                values.clear();
                //开始组装第二条数据
                values.put("name","The Lost Symbol");
                values.put("author","Dan Brown");
                values.put("pages","510");
                values.put("price","19.95");
                db.insert("Book",null,values);
            }
        });

        mBtnUpdataData = findViewById(R.id.btn_update_data);
        mBtnUpdataData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //更新数据
                values.put("price","10.96");
                db.update("Book",values,"name = ?",new String[]{"The Da Vinci Code"});
            }
        });

        mBtnDeleteData = findViewById(R.id.btn_delete_data);
        mBtnDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //删除数据
                db.delete("Book","pages > ?",new String[]{"500"});
            }
        });

        mBtnQueryData = findViewById(R.id.btn_query_data);
        mBtnQueryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //查询Book表中的所有数据
                text_name = findViewById(R.id.text_name);
                text_author = findViewById(R.id.text_author);
                text_pages = findViewById(R.id.text_pages);
                text_price = findViewById(R.id.text_price);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book",null,null,null,
                        null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        //遍历Cursor对象，取出数据并打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        text_name.setText(name);
                        text_author.setText(author);
                        text_pages.setText(String.valueOf(pages));
                        text_price.setText(String.valueOf(price));
                    }while(cursor.moveToNext());
                }
                cursor.close();
            }
        });

        //execSQL()语句可以执行update,insert,delete等SQL语句
        //rawQuery()可以执行select语句
    }

    //新建一个MyDatabaseHelper类继承自SQLiteOpenHelper类
    public class MyDatabaseHelper extends SQLiteOpenHelper {

        //sql语句
        public static final String CREATE_TABLE = "create table Book ("
                +"id integer primary key autoincrement,"
                +"author text,"
                +"price real,"
                +"pages integer,"
                +"name text)";

        public static final String CREATE_CATEGORY = "create table Category("
                +"id integer primary key autoincrement,"
                +"category_name text,"
                +"category_code integer)";

        private Context mContext;

        //构造函数
        public MyDatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
            super(context,name,factory,version);
            mContext = context;
        }

        @Override
        //创建数据库
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //执行sql语句
            sqLiteDatabase.execSQL(CREATE_TABLE);
            sqLiteDatabase.execSQL(CREATE_CATEGORY);
            ToastUtil.showMsg(DatabaseTestActivity.this,"Create Succeeded!");
        }
        //升级数据库
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("drop table if exists Book");
            sqLiteDatabase.execSQL("drop table if exists Category");
            onCreate(sqLiteDatabase);
        }
    }
}
