package cn.yqd.service;

import cn.yqd.entity.User;
import cn.yqd.service.fallback.IndexFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cloud-user",fallbackFactory = IndexFallBack.class)
public interface IndexService {

    @RequestMapping(value = "/getUser1", method = RequestMethod.POST)
    User getUser1(User user);

}
