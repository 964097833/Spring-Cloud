package cn.yqd.controller;

import cn.yqd.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;
    @RequestMapping("/index")
    public Object index() {
        String index = indexService.index();
        return index;
    }
}
