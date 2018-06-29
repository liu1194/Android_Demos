package com.example.liupengcheng.helloworld.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.liupengcheng.helloworld.R;

/**
 * Created by Liu Pengcheng on 2018/2/28.
 */

public class MyGridAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public  MyGridAdapter(Context context){
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
        public TextView textView;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = mLayoutInflater.inflate(R.layout.layout_grid_view,null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.iv_grid);
            holder.textView = view.findViewById(R.id.tv_grid_title);
            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();
        }
        //赋值
        holder.textView.setText("flower");
        Glide.with(mContext).load("http://www.fansimg.com/forum/201511/10/162709rnej8k9ejii9ves8.jpg").into(holder.imageView);
        return view;
    }
}
