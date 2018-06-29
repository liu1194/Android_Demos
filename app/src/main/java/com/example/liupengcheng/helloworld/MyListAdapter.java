package com.example.liupengcheng.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Liu Pengcheng on 2018/2/27.
 */

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyListAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.list_iv);
            holder.tvTitle = view.findViewById(R.id.list_tv_title);
            holder.tvTime = view.findViewById(R.id.list_tv_time);
            holder.tvContent = view.findViewById(R.id.list_tv_content);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        //给控件fuzhi
        holder.tvTitle.setText("this is title");
        holder.tvTime.setText("time");
        holder.tvContent.setText("this is content");
        Glide.with(mContext).load("http://www.ahjzu.edu.cn/_upload/tpl/00/83/131/template131/images/top.jpg").into(holder.imageView);
        return view;
    }
}
