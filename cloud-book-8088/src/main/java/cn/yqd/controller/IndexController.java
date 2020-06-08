package cn.yqd.controller;

import cn.yqd.controller.helper.IndexHelper;
import cn.yqd.entity.User;
import cn.yqd.service.IndexService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private IndexHelper indexHelper;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Object index(User user) {
        String index = null;
        System.out.println("public Object index(User user) {"+user);
        for (int i = 0; i < 10; i++) {
            index = indexHelper.doSomething(String.valueOf(user.getAge()));
        }
        return index;
    }
}
