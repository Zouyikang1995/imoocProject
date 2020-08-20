package com.hosdep.dao;

import com.hosdep.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
    User selectByUsername(String username);
}
