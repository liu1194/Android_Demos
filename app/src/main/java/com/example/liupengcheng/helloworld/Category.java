package com.example.liupengcheng.helloworld;

import org.litepal.crud.LitePalSupport;

public class Category extends LitePalSupport{
    private int id;
    private String Category_name;
    private int Category_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return Category_name;
    }

    public void setCategory_name(String category_name) {
        Category_name = category_name;
    }

    public int getCategory_code() {
        return Category_code;
    }

    public void setCategory_code(int category_code) {
        Category_code = category_code;
    }
}
