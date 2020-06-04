package cn.yqd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ApplicationMain8084 {
    @RequestMapping("/health")
    public String health() {
        return "200";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8084.class, args);
    }

}
