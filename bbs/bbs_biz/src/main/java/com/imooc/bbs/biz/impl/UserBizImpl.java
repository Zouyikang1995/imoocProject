package com.imooc.bbs.biz.impl;

import com.imooc.bbs.biz.UserBiz;
import com.imooc.bbs.dao.UserDao;
import com.imooc.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userBiz")
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserDao userDao;

    public User login(String username, String password) {
        User user = userDao.select(username);
        //判断用户是否存在并且密码是否匹配
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void register(User user) {
        //用户初始化是，状态为正常
        user.setUserStatus(0);
        userDao.insert(user);
    }

    public void normal(int id) {
        userDao.statusChange(id, 0);
    }

    public void lock(int id) {
        userDao.statusChange(id, 1);
    }

    public void disable(int id) {
        userDao.statusChange(id, 2);
    }

    public List<User> getAll() {
        return userDao.selectAll();
    }
}
