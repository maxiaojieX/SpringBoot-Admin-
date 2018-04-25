package com.springboot.admin.service;


/**
 *@author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/6.
 */
public interface MaintainService {

    /**
     * 维护应用
     * @param appName
     * @return
     */
    String mainTain(String appName);

    /**
     * 取消维护
     * @param appName
     * @return
     */
    String cancelMainTain(String appName);

    String clearStatus(String app);

}
