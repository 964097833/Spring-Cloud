package cn.yqd.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }
}
