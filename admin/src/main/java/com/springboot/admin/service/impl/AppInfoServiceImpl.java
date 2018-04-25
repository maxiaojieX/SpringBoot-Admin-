package com.springboot.admin.service.impl;

import com.alibaba.fastjson.JSON;

import com.springboot.admin.bean.App;
import com.springboot.admin.service.AppInfoGetService;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by xiaojie.Ma on 2018/4/9.
 */
@Service
public class AppInfoServiceImpl implements AppInfoGetService {
    @Override
    public List<App> getAppInfo() {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8601/api/applications");

        HttpResponse httpResponse = null;
        String result = null;
        try {
            httpResponse = closeableHttpClient.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                InputStream inputStream = httpResponse.getEntity().getContent();
                result = IOUtils.toString(inputStream,"UTF-8");
            }
        }catch (IOException i){
            i.printStackTrace();
        }

        List<App> apps = JSON.parseArray(result,App.class);
//        去重
        Map<String,Object> map = new HashMap<String, Object>();
        if(apps!= null) {
            for(App app :apps) {
                if(!map.containsKey(app.getName())){
                    map.put(app.getName(),app);
                }
            }
        }
        List<App> apps1 = new ArrayList<App>();
        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String name = it.next();
            App app = (App) map.get(name);
            apps1.add(app);
        }
        map=null;
        return apps1;
    }
}
