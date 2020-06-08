package cn.yqd;

import cn.yqd.config.ribbon.UserRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@SpringCloudApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@RibbonClients({
        @RibbonClient(name = "cloud-user", configuration = UserRibbonConfig.class)
})
@ServletComponentScan
public class ApplicationMain8088 {
    @RequestMapping("/health")
    public String health() {
        return "200";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8088.class,args);
    }
}
