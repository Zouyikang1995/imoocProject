package com.imooc.bbs.biz;

import com.imooc.bbs.entity.User;

import java.util.List;

public interface UserBiz {
    void register(User user);
    void normal(int id);
    void lock(int id);
    void disable(int id);
    List<User> getAll();
    public User login(String username, String password);
}
