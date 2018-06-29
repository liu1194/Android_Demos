package com.example.liupengcheng.helloworld.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Liu Pengcheng on 2018/3/6.
 */

public class ToastUtil {
    public static Toast mToast;
    public static void showMsg(Context context, String msg){
        if(mToast == null){
            mToast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else{
            mToast.setText(msg);
        }
        mToast.show();
    }
}
