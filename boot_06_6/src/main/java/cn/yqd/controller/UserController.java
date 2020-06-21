package cn.yqd.controller;

import cn.yqd.bean.User;
import cn.yqd.dao.UserDao;
import cn.yqd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping({"/","/index"})
    public Object index() {
        List<User> selectMyUsers = userDao.selectMyUsers();
        System.out.println("所有的用户信息："+selectMyUsers);

        User user = new User();
        user.setId(2);
        List<User> selectOneUserById = userDao.selectOneUserById(user);
        System.out.println("得到id为"+user.getId()+"的用户信息是："+selectOneUserById);

        List<User> selectOneUserById2 = userDao.selectOneUserById2(2);
        System.out.println("得到id为"+2+"的用户信息是："+selectOneUserById2);

        User user2 = new User();
        user2.setId(2);
        user2.setUserName("myUsername222");
        user2.setUserPwd("myPwd222");
        int updateOneUserById = userDao.updateOneUserById(user2);
        System.out.println("updateOneUserById:"+updateOneUserById);

        int deleteOneUserById = userDao.deleteOneUserById(2);
        System.out.println("deleteOneUserById:"+deleteOneUserById);

        return selectMyUsers;
    }

    @Autowired
    private UserService service;

    @RequestMapping({"/service1/{id}/{username}/{password}"})
    public Object controller1(
            @PathVariable("username") String username,
            @PathVariable("password") String password,
            @PathVariable("id") Integer id) throws Exception{

        User user2 = new User();
        user2.setId(id);
        user2.setUserName(username);
        user2.setUserPwd(password);
        int service1 = 0;
        try {
            service1 = service.service1(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service1;
    }

    @RequestMapping({"/service2/{id}/{username}/{password}"})
    public Object controller2(
            @PathVariable("username") String username,
            @PathVariable("password") String password,
            @PathVariable("id") Integer id) throws Exception{

        User user2 = new User();
        user2.setId(id);
        user2.setUserName(username);
        user2.setUserPwd(password);
        int service1 = 0;
        try {
            service1 = service.service2(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service1;
    }
}
