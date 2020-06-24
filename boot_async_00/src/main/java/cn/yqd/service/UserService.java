package cn.yqd.service;

import cn.yqd.bean.User;
import cn.yqd.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

	@Autowired
	private UserDao userDao;
	
	/**
	 * 查询所有用户
	 * @return 
	 */
	public List<User> findUserAll() {
		return userDao.findAll();
	}
	
	/**
	 * 根据id查询用户
	 * @return 
	 */
	public User findUserById(Long id) {
		return userDao.findByUserNo(id);
	}
	
	/**
	 * 添加用户
	 * @return 
	 */
	public User saveUser(User user) {
		User thisUser = userDao.save(user);
		return thisUser;
	}
	/**
	 * 删除用户
	 * @return 
	 */
	public String deleteUserById(User user) {
		try {
			userDao.delete(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}