package com.springboot.admin.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/15.
 */
public class JsonCommonUtil {

    public static String code200() {
        Map<String,Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("code",200);
        jsonMap.put("msg","success");
        String json = JSON.toJSONString(jsonMap);
        jsonMap = null;
        return json;
    }

    public static String code400(){
        Map<String,Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("code",400);
        jsonMap.put("msg","请求参数异常");
        String json = JSON.toJSONString(jsonMap);
        jsonMap = null;
        return json;
    }

    public static String code404() {
        Map<String,Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("code",404);
        jsonMap.put("msg","请求资源找不到");
        String json = JSON.toJSONString(jsonMap);
        jsonMap = null;
        return json;
    }

    public static String code500() {
        Map<String,Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("code",500);
        jsonMap.put("msg","服务器故障");
        String json = JSON.toJSONString(jsonMap);
        jsonMap = null;
        return json;
    }

}
