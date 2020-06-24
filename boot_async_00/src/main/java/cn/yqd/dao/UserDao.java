package cn.yqd.dao;

import cn.yqd.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 根据用户名称查询用户
     * @param id
     * @return
     */
    User findByUserNo(Long id);
}