package com.wxy.micro.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RetObject implements Serializable{
    private String msg;
    private Integer code;
    private JSONObject result;
    public static RetObject successRet(String msg,JSONObject result){
        return new RetObject(msg,1001,result);
    }
    public static RetObject failRet(String msg,Integer code){
        return new RetObject(msg,code,null);
    }
}
