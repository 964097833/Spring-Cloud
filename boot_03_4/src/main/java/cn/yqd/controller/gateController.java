package cn.yqd.controller;

import cn.yqd.config.ExecutorConfig;
import cn.yqd.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class gateController {
    @Autowired
    private GatewayService gatewayService;
    @Autowired
    private ExecutorConfig executorConfig;
    @Autowired
    private ApplicationContext context;

    @RequestMapping("/gateway/{username}")
    public String gateway(@PathVariable final String username) throws Exception {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 6; i++) {
            gatewayService.getAlipayGateway(username);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("调用gateway消耗的时间为："+(endTime-startTime)+"ms");
        return "调用gateway消耗的时间为："+(endTime-startTime)+"ms";
    }

    @RequestMapping("/gateway2/{username}")
    public String gateway2(@PathVariable final String username) throws Exception {
        Long startTime = System.currentTimeMillis();
        Future<String> alipaygateway = gatewayService.getAlipayGatewayString(username);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("调用gateway消耗的时间为："+(endTime-startTime)+"ms");
        return alipaygateway.get();
    }
    @RequestMapping("/shutDown")
    public boolean shutDown() {
        System.out.println("调用异步线程池shutdown接口");
        //从spring容器中获取线程池
        ThreadPoolTaskExecutor t = (ThreadPoolTaskExecutor) context.getBean("myExecutor");
        boolean asyncShutDown = executorConfig.asyncShutDown(t);
        return asyncShutDown;
    }
}
