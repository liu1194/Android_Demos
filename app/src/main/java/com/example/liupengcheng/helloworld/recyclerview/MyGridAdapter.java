package com.example.liupengcheng.helloworld.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.liupengcheng.helloworld.R;

/**
 * Created by Liu Pengcheng on 2018/3/2.
 */

public class MyGridAdapter extends RecyclerView.Adapter<MyGridAdapter.GridViewHolder> {

    private Context mContext;
    public MyGridAdapter(Context context){ this.mContext = context; }

    @Override
    public MyGridAdapter.GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GridViewHolder gridViewHolder = new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_view,parent,false));
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(MyGridAdapter.GridViewHolder holder, final int position) {
        holder.textView.setText("flower");
        Glide.with(mContext).load("http://www.fansimg.com/forum/201511/10/162709rnej8k9ejii9ves8.jpg").into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }
    class GridViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;

        public GridViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_grid_title);
            imageView = itemView.findViewById(R.id.iv_grid);
        }
    }
}
