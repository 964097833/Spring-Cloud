package cn.yqd.controller;

import cn.yqd.bean.User;
import cn.yqd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping({"/","/index"})
	public Object index(){
		return userService.findUserAll();
	}
	
	@PostMapping({"/save"})
	public Object saveUser(@RequestBody User user){
		System.out.println(user);
		return userService.saveUser(user);
	}
	
	@RequestMapping({"/findUserById/{id}"})
	public Object findUserById(@PathVariable Long id){
		System.out.println(id);
		return userService.findUserById(id);
	}
	
	@RequestMapping({"/deleteUserById/{id}"})
	public Object deleteUserById(@PathVariable Long id){
		System.out.println(id);
		User user = new User();
		user.setId(id);
		return userService.deleteUserById(user);
	}
}