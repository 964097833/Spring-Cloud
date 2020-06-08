package cn.yqd.controller;

import cn.yqd.service.IndexService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;

    @HystrixCommand(fallbackMethod = "defaultMethod")
    @RequestMapping("/index")
    public Object index() {
        String index = indexService.index();
        int i = 10/0;
        return index;
    }

    public String defaultMethod(Throwable throwable) {
        System.out.println("已进入private String defaultMethod()");
        System.out.println(throwable.getMessage());
        return "系统超时";
    }
}
