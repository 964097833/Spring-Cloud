package cn.yqd.dao;

import cn.yqd.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query(value="select * from user",nativeQuery = true)
	List<User> selectMyUsers();
	@Query(value="select * from user where user.id =:#{#userParam.id}",nativeQuery = true)
	List<User> selectOneUserById(@Param("userParam") User user);
	@Query(value="select * from user u where u.id =?1",nativeQuery = true)
	List<User> selectOneUserById2(int id);
//	@Transactional(propagation= Propagation.REQUIRES_NEW)
	@Modifying
	@Query(value="insert into user values(':#{#userParam.no}',':#{#userParam.userName}',':#{#userParam.userPwd}','')",nativeQuery = true)
	int insertOneUser(@Param("userParam") User user);
	@Modifying
	@Query(value="update user set user_name=:#{#userParam.userName} , user_pwd=:#{#userParam.userPwd} where id=:#{#userParam.id}",nativeQuery = true)
	int updateOneUserById(@Param("userParam") User user);
	@Modifying
	@Query(value="DELETE FROM user where id =:id",nativeQuery = true)
	int deleteOneUserById(@Param("id")int id);
}