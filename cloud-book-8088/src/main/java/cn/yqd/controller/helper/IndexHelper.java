package cn.yqd.controller.helper;

import cn.yqd.entity.User;
import cn.yqd.service.IndexService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class IndexHelper {
    @Autowired
    private IndexService indexService;

    @CacheResult(cacheKeyMethod = "getUserAge")
    @HystrixCommand(fallbackMethod = "defaultMethod")
    public String doSomething(String age) {
        String name = Thread.currentThread().getName();
        System.out.println("当前线程名为："+ name);
        User user = new User();
        user.setAge(Integer.valueOf(age));
        String something = indexService.getUser1(user).toString();
//        String something = user.toString();
        Random random = new Random();
        System.out.println("something"+something+"||"+random.nextInt());
        return something;
    }

    @SuppressWarnings("unused")
    private String defaultMethod(String age) {
        System.out.println("已进入private String defaultMethod()");
        return "系统潮湿";
    }

    public String getUserAge(String age) {
        System.out.println("public String getUserAge(String age) {"+age);
        return age;
    }
}
