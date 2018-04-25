package com.springboot.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.springboot.admin.config.Information;
import com.springboot.admin.service.GetJsonService;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/6.
 */
@Service
public class GetJsonServiceImpl implements GetJsonService {


    @Override
    public String getJson2() {
        if(Information.maintain.size()==0 && Information.appDown.size()==0) {
            Map<String,Object> json = new Hashtable<String, Object>();
            json.put("code",200);
            json.put("value",0);
            String j = JSON.toJSONString(json);
            json = null;
            return j;
        }else {

            Map<String,Object> json = new Hashtable<String, Object>();

            Map<String,Object> temporary = new Hashtable<String, Object>();
            temporary.putAll(Information.maintain);

//            screenMap 用于筛选最终宕机信息
            Map<String,Object> screenMap = new Hashtable<String, Object>();
            screenMap.putAll(Information.appDown);

            Iterator maintainKeys = Information.maintain.keySet().iterator();
            Iterator downKeys = Information.appDown.keySet().iterator();

            while (maintainKeys.hasNext()){
                String mainKey = (String) maintainKeys.next();
                while (downKeys.hasNext()){
                    String downKey = (String) downKeys.next();
//                    BUG service-page和service-page-feign问题
                    if(downKey.startsWith(mainKey) && !downKey.split(mainKey)[1].startsWith("-")) {
                        screenMap.remove(downKey);
                    }
                }
            }

            int value = screenMap.size();
            temporary.putAll(screenMap);

            Iterator temporaryKeys = temporary.keySet().iterator();
            StringBuffer msg = new StringBuffer();
            while (temporaryKeys.hasNext()){
                String k = (String) temporaryKeys.next();
                msg.append(temporary.get(k)).append(",");
            }
            String m = msg.substring(0,msg.length()-1);
            json.put("code",200);
            json.put("msg",m);
            json.put("value",value);

            String j = JSON.toJSONString(json);

            json = null;
            temporary = null;
            screenMap = null;
            return j;
        }

    }

}
