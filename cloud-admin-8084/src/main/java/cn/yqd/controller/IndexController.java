package cn.yqd.controller;

import cn.yqd.entity.User;
import cn.yqd.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/index")
    public String index() {
        User user = new User();
        user.setAge(23);
        user.setName("余乔弟");
        return indexService.getUser1(user).toString();
    }

}
