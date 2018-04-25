package com.springboot.admin.config;


import com.springboot.admin.common.NotifyConstant;
import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.notify.SlackNotifier;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/6.
 */
public class SlackReminder extends SlackNotifier {

    @Override
    protected void doNotify(ClientApplicationEvent event) throws Exception {

        String appName = event.getApplication().getName();
        String managermentURL = event.getApplication().getManagementUrl();
//        UP / OFFLINE
        String appStatus = event.getApplication().getStatusInfo().getStatus();
        if(NotifyConstant.APP_UP.equals(appStatus)) {
//            应用上线，判断宕机Map中是否有该应用name,如果有->移除
            if(Information.appDown.containsKey(appName+"_"+managermentURL)) {
                Information.appDown.remove(appName+"_"+managermentURL);
            }
        }else if(NotifyConstant.APP_OFFLINE.equals(appStatus)) {
//            应用下线,把信息装到宕机Map中
            Information.appDown.put(appName+"_"+managermentURL,appName+"_"+managermentURL+"宕机告警");
        }


    }

}
