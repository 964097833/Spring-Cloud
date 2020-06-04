package cn.yqd.controller;

import cn.yqd.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @RequestMapping(value = "/getUser1", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户方法1", notes = "通过post请求获取用户", produces = "application/json",
            tags = "UserController")
    public User getUser1(@RequestBody User user) {
        user.setAge(user.getAge());
        user.setName("已进入cloud-user-8083项目getUser当中");
        System.out.println("user.toString()"+user.toString());
        return user;
    }
    @RequestMapping(value = "/getUser2/{name}/{age}", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户方法2", notes = "通过get@PathVariable方式请求获取用户")
    @ApiImplicitParams ({
            @ApiImplicitParam(name = "name", value = "用户名", paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "用户年龄", paramType = "path", dataType = "int"),
    })
    public User getUser2(@PathVariable String name, @PathVariable int age) {
        User user = new User();
        user.setAge(age);
        user.setName("已进入cloud-user-8083项目getUser2当中");
        System.out.println("user.toString()"+user.toString());
        return user;
    }

    @RequestMapping(value = "/getUser3", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户方法3", notes = "获取用户方法3notes", produces = "application/json")
    public User getUser3(@ModelAttribute User user) {
        user.setAge(user.getAge());
        user.setName("已进入cloud-user-8083项目getUser3当中");
        System.out.println("user.toString()"+user.toString());
        return user;
    }

}
