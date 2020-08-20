package com.imooc.demo1;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {

    public void save();

    public void update();

    public void delete();

    public void find();

}
