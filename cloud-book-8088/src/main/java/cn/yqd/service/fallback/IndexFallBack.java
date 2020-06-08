package cn.yqd.service.fallback;

import cn.yqd.entity.User;
import cn.yqd.service.IndexService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class IndexFallBack implements FallbackFactory<IndexService> {

    @Override
    public IndexService create(Throwable throwable) {
        return new IndexService() {
            @Override
            public User getUser1(User user) {
                User user1 = new User();
                user1.setName("fallback中的user");
                return user1;
            }
        };
    }
}
