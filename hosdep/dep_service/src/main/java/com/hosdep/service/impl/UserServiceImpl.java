package com.hosdep.service.impl;

import com.hosdep.dao.UserDao;
import com.hosdep.entity.User;
import com.hosdep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user = userDao.selectByUsername(username);
        if (user == null) return null;
        if (user.getPassword().equals(password)) return user;
        return null;
    }
}
