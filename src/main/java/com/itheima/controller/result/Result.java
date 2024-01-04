package com.itheima.controller.result;

import lombok.Data;

/**
 * @author 凯祥
 */
@Data
public class Result {
    private Boolean flag;
    private Object data;
    private String msg;

    public Result(){}

    //修改信息格式
    public Result(Boolean flag){
        this.flag = flag;

    }
    //查询信息格式
    public Result(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
    //抛出异常格式
    public Result(String msg){
        this.flag = false;
        this.msg = msg;
    }
    //添加信息成功失败返回信息格式
    public Result(Boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }
    //查询成功失败格式
    public Result(Boolean flag,Object data,String msg){
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }
}
