package com.springboot.admin.service;


import com.springboot.admin.bean.App;

import java.util.List;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/9.
 */
public interface AppInfoGetService {

    /**
     * 获取被监控项目
     * @return
     */
    List<App> getAppInfo();

}
