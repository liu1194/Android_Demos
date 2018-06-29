package com.example.liupengcheng.helloworld.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.liupengcheng.helloworld.FragmentTestActivity;
import com.example.liupengcheng.helloworld.R;
import com.example.liupengcheng.helloworld.util.ToastUtil;

import java.util.zip.Inflater;

/**
 * Created by Liu Pengcheng on 2018/3/9.
 */

public class LeftFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment,container,false);
        return view;
    }
}
