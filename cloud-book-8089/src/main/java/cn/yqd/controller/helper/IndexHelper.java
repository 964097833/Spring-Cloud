package cn.yqd.controller.helper;

import cn.yqd.entity.User;
import cn.yqd.service.IndexService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapser.Scope;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

@Service
public class IndexHelper {
    @Autowired
    private IndexService indexService;

    @HystrixCollapser(batchMethod = "doSomethings", scope = Scope.GLOBAL, collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "3000")
    })
    public Future<User> doSomething(String age) {
        System.out.println("****");
        return null;
    }

    @HystrixCommand
    public List<User> doSomethings(List<String> ages) {
        System.out.println("CollapserListGLOBAL当前线程"+Thread.currentThread().getName());
        System.out.println("当前请求参数个数："+ages.size());
        System.out.println("ages参数："+ages);
        List<User> users = new ArrayList<>();
        for (String age : ages) {
            User user = new User();
            user.setAge(Integer.valueOf(age));
            users.add(user);
            String returnUser = indexService.getUser1(user).toString();
            System.out.println(returnUser);
        }
        return users;
    }
}
