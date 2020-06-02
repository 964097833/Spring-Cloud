package cn.yqd.controller;

import cn.yqd.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private MyConfig myConfig;

    @RequestMapping("/getMyConfig")
    public String getMyConfig() {
        return myConfig.toString();
    }

    @RequestMapping("/getUsername")
    public String getUsername() {
        return myConfig.getUsername();
    }

    @RequestMapping("/getYear")
    public String getYear() {
        return myConfig.getMy().getYear();
    }

}
