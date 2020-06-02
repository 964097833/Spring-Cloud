package cn.yqd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    /**
     * 从所有服务中获得一个服务地址
     */
    @RequestMapping("/discover/{serviceName}")
    public Object discover(@PathVariable String serviceName) {
        return loadBalancerClient.choose(serviceName).getUri().toString();
    }
    /**
     * 获取某个服务的全部信息，包括僵尸节点和负载节点
     */
    @RequestMapping("services/{serviceName}")
    public Object getServicesBy(@PathVariable String serviceName) {
        return discoveryClient.getInstances(serviceName);
    }
}
