package com.hosdep.service;

import com.hosdep.entity.User;

public interface UserService {
    User login(String username, String password);
}
