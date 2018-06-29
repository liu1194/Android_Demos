package com.example.liupengcheng.helloworld.fragmentbestpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liupengcheng.helloworld.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Liu Pengcheng on 2018/3/10.
 */

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

    private List<News> getNews(){
        List<News> newsList = new ArrayList<>();
        for (int i = 1;i <= 50;i++){
            News news = new News();
            news.setTitle("there is news title" + i);
            news.setContent(getRandomLengthContent("there is news content"+ i +"."));
            newsList.add(news);
            Log.d("news","news news");
        }
        return newsList;
    }

    private String getRandomLengthContent(String content){
        Random random = new Random();
        int lenght = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<lenght;i++){
            builder.append(content);
        }
        return builder.toString();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        RecyclerView newsTitleRecyclerView = view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(adapter);
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout) != null){
            isTwoPane = true;
        }else{
            isTwoPane = false;
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Viewholder>{

        private List<News> mNewsList;

        class Viewholder extends RecyclerView.ViewHolder{
            TextView newsTitleText;

            public Viewholder(View itemView) {
                super(itemView);
                newsTitleText = itemView.findViewById(R.id.news_title);
            }
        }

        public NewsAdapter(List<News> newsList){
            mNewsList = newsList;
        }

        @Override
        public NewsAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
            final Viewholder holder = new Viewholder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if(isTwoPane){
                        //如果是双页模式则刷新NewsContentFragment中的内容
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitle(),news.getContent());
                    }else{
                        //如果是单页模式则直接启动NewsContentActivity
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(NewsAdapter.Viewholder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }
    }
}
