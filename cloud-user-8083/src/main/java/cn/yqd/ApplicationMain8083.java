package cn.yqd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationMain8083 {

    @RequestMapping("/health")
    public String health() {
        return "200";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8083.class, args);
    }
}
