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

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.GridViewHolder> {

    private Context mContext;
    public StaggeredGridAdapter(Context context){ this.mContext = context; }

    @Override
    public StaggeredGridAdapter.GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GridViewHolder gridViewHolder = new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_item,parent,false));
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(StaggeredGridAdapter.GridViewHolder holder, final int position) {
        if(position % 2 != 0){
            Glide.with(mContext).load("http://www.fansimg.com/forum/201511/10/162709rnej8k9ejii9ves8.jpg").into(holder.imageView);
        }else{
            Glide.with(mContext).load("http://pic.58pic.com/58pic/14/59/13/19K58PIC59d_1024.jpg").into(holder.imageView);
        }

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

        private ImageView imageView;

        public GridViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_staggered);
        }
    }
}
