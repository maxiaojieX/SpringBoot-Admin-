package com.springboot.admin.controller;

import com.springboot.admin.bean.App;
import com.springboot.admin.common.NotifyConstant;
import com.springboot.admin.config.Information;
import com.springboot.admin.service.AppInfoGetService;
import com.springboot.admin.service.GetJsonService;
import com.springboot.admin.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/25.
 */
@Controller
public class AdminController {

    @Autowired
    private GetJsonService getJsonService;
    @Autowired
    private AppInfoGetService appInfoGetService;
    @Autowired
    private MaintainService maintainService;

    /**
     * 暴露状态接口
     * @return
     */
    @GetMapping("/status")
    @ResponseBody
    public String appStatus2() {
        return getJsonService.getJson2();
    }


    @GetMapping("/doMaintain")
    @ResponseBody
    public String maintain(String app) {
        return maintainService.mainTain(app);
    }

    @GetMapping("/cancel")
    @ResponseBody
    public String cancel(String app) {
        return maintainService.cancelMainTain(app);
    }
    @GetMapping("/maintain")
    public String warn(Model model) {
        List<App> apps = appInfoGetService.getAppInfo();
        for(App app : apps) {
            if(Information.maintain.containsKey(app.getName())) {
                app.setMaintain(NotifyConstant.STATUS_MAINTAINING);
            }else {
                app.setMaintain(NotifyConstant.STATUS_NOTMAINTAIN);
            }
        }
        model.addAttribute("apps",apps);
        return "warn";
    }

    @RequestMapping("/clearApp")
    @ResponseBody
    public String clearStatusJson(String app) {
        return maintainService.clearStatus(app);
    }
}
