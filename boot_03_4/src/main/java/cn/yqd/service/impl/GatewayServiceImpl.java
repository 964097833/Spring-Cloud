package cn.yqd.service.impl;

import cn.yqd.service.GatewayService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class GatewayServiceImpl implements GatewayService {
    @Async("myExecutor")
    @Override
    public void getAlipayGateway(String username) {
        System.out.println("已进来获得网关路径服务，username："+username+"线程名为："
            +Thread.currentThread().getName());
        Long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("线程"+Thread.currentThread().getName()+"消耗的时间为"+(endTime-startTime)+"ms");
    }
    @Async
    @Override
    public Future<String> getAlipayGatewayString(String username) {
        Future<String> future;
        System.out.println("已进来获取网关路径服务：username为"+username);
        Long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            future = new AsyncResult<>("错误提示："+e.getMessage());
            e.printStackTrace();
            return future;
        }

        Long endTime = System.currentTimeMillis();
        System.out.println("线程"+Thread.currentThread().getName()+"消耗的时间为："+(endTime-startTime)+"ms");
        future = new AsyncResult<>("线程"+Thread.currentThread().getName()+"消耗的时间为："
                +(endTime-startTime)+"ms");
        return future;
    }
}
