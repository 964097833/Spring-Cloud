package cn.yqd.controller;

import cn.yqd.entity.User;
import cn.yqd.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
public class IndexController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping({"/","/index"})
    public String index(){
        return "Hello World" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    @RequestMapping("/redisSave/{key}/{value}")
    public String save(@PathVariable String key, @PathVariable String value){
        try {
            redisUtils.setValue(key, new User(value, new Random().nextInt(30)));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
