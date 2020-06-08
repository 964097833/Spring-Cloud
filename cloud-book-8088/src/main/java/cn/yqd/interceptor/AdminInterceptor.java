package cn.yqd.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type","application/json");
        requestTemplate.header("token","123456");
        System.out.println("已进入AdminInterceptor拦截器中");
    }
}
