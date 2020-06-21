package cn.yqd.service.impl;

import cn.yqd.bean.User;
import cn.yqd.dao.UserDao;
import cn.yqd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor=Exception.class)
    public int service1(User user2){
        int updateOneUserById = userDao.updateOneUserById(user2);
        int i = 1/0;
        System.out.println("service1"+updateOneUserById);
        return updateOneUserById;
    }

    @Transactional(noRollbackFor=java.lang.ArithmeticException.class)
    public int service2(User user2){
		int updateOneUserById = userDao.updateOneUserById(user2);
		int i = 1/0;
		System.out.println("service2"+updateOneUserById);
        return updateOneUserById;
    }
}
