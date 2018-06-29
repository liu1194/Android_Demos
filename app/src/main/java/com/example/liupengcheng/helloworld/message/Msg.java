package com.example.liupengcheng.helloworld.message;

/**
 * Created by Liu Pengcheng on 2018/3/9.
 */

public class Msg {

    public static final int TYPE_RECEIVED = 0;

    public static final int TYPE_SEND = 1;

    private String content; //消息内容

    private int type; //消息类型

    public Msg(String content,int type){
        this.content = content;
        this.type = type;
    }

    public String getContent(){
        return content;
    }
    public int getType(){
        return type;
    }
}
