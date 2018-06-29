package com.example.liupengcheng.helloworld.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liupengcheng.helloworld.R;

/**
 * Created by Liu Pengcheng on 2018/3/2.
 */

public class MyHorAdapter extends RecyclerView.Adapter<MyHorAdapter.HorViewHolder>{

    private Context mContext;
    public MyHorAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public MyHorAdapter.HorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HorViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHorAdapter.HorViewHolder holder, final int position) {
        holder.textView.setText("hello");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }
    class HorViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public HorViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_hor_title);
        }
    }
}
