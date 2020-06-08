package cn.yqd;

import cn.yqd.config.ribbon.UserRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@RibbonClients({
        @RibbonClient(name = "cloud-admin",configuration = UserRibbonConfig.class)
})
public class ApplicationMain8086 {
    @RequestMapping("/health")
    public String health() {
        return "200";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8086.class,args);
    }
}
