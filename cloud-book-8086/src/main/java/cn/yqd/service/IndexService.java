package cn.yqd.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cloud-admin")
public interface IndexService {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    String index();
}
