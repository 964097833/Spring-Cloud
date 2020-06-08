package cn.yqd;

import cn.yqd.config.ribbon.UserRibbonConfig;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.hystrix.contrib.sample.stream.HystrixConfigSseServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@RibbonClients({
        @RibbonClient(name = "cloud-user",configuration = UserRibbonConfig.class),
        @RibbonClient(name = "cloud-admin",configuration = UserRibbonConfig.class)
})
@SpringCloudApplication
public class ApplicationMain8087 {
    @RequestMapping("/health")
    public String health() {
        return "200";
    }

    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> hystrixMetricsStreamServlet() {
        ServletRegistrationBean<HystrixMetricsStreamServlet> registration
                = new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
        registration.addUrlMappings("/hystrix.stream");
        return registration;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8087.class,args);
    }
}
