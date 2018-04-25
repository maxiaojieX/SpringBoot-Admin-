package com.springboot.admin.config;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/6.
 */
public class Information {

    /**
     * 应用宕机信息Map
     */
    public static Map<String,Object> appDown = new Hashtable<String, Object>();

    /**
     * 应用维护列表Map
     */
    public static Map<String,Object> maintain = new Hashtable<String, Object>();



}
