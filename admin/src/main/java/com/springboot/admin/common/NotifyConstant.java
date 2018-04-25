package com.springboot.admin.common;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/8.
 */
public class NotifyConstant {

    /**
     * 监控应用上线是触发的状态信息
     */
    public static final String APP_UP = "UP";

    /**
     * 监控应用下线时触发的状态信息
     */
    public static final String APP_OFFLINE = "OFFLINE";

    /**
     * 维护中
     */
    public static final Integer STATUS_MAINTAINING = 1;

    /**
     * 未维护
     */
    public static final Integer STATUS_NOTMAINTAIN = 0;

}
