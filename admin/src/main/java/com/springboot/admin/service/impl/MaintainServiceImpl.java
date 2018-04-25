package com.springboot.admin.service.impl;

import com.springboot.admin.config.Information;
import com.springboot.admin.service.MaintainService;
import com.springboot.admin.util.JsonCommonUtil;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/17.
 */
@Service
public class MaintainServiceImpl implements MaintainService {

    private  final  static String MAINTAINMSG = "应用维护";

    @Override
    public String mainTain(String appName) {
        Information.maintain.put(appName,appName+".*"+MAINTAINMSG);
        return JsonCommonUtil.code200();
    }

    @Override
    public String cancelMainTain(String appName) {
        Information.maintain.remove(appName);
        return JsonCommonUtil.code200();
    }

    @Override
    public String clearStatus(String app) {
        Information.maintain.remove(app);
        Set<String> keySet = Information.appDown.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()){
            String name = it.next();
            if(name.equals(app)) {
                Information.appDown.remove(name);
            }
        }
        return JsonCommonUtil.code200();
    }

}
