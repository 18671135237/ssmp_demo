package com.example.springboot_ssmp_demo.controller.utils;

import lombok.Data;

// 接口数据返回统一格式模板
@Data
public class ReturnModel {
/*
    {"flag":"true","data":null}

    {"flag":"false","msg":}

*/
    private Boolean flag; // 是否成功
    private Object data; // 返回数据
    private String msg; // 异常信息

    public ReturnModel(){}
    public ReturnModel(Boolean flag){
        this.flag = flag;
    }
    public ReturnModel(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
    public ReturnModel(Boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }
    public ReturnModel(Boolean flag,Object data,String msg){
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }
    public ReturnModel(String msg){
        this.flag = false;
        this.msg = msg;
    }

}
