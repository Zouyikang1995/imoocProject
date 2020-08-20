package com.imooc.bbs.dao;

import com.imooc.bbs.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    void insert(User user);
    User select(String username);
    List<User> selectAll();
    void statusChange(@Param("id") int id, @Param("status") int status);
}
