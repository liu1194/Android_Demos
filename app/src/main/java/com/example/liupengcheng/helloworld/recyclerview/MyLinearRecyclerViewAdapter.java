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
 * Created by Liu Pengcheng on 2018/2/28.
 */

public class MyLinearRecyclerViewAdapter extends RecyclerView.Adapter<MyLinearRecyclerViewAdapter.LinearViewHolder> {

    private Context mContext;
    public MyLinearRecyclerViewAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public MyLinearRecyclerViewAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
    }

    @Override
    public void onBindViewHolder(MyLinearRecyclerViewAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello World!");
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

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_linear_title);
        }
    }
}
