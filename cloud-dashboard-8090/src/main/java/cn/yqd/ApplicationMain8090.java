package cn.yqd;

import cn.yqd.ribbon.UserRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@RibbonClients({
        @RibbonClient(name = "cloud-user",configuration = UserRibbonConfig.class)
})
@SpringCloudApplication
@ServletComponentScan
@EnableHystrixDashboard
public class ApplicationMain8090 {
    @RequestMapping("/health")
    public String health() {
        return "200";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8090.class,args);
    }
}
