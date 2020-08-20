package com.imooc.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
    @Test
    public void demo1() {
        UserDao userDao = new UserDaoImpl();

        UserDao proxy = (UserDao) new MyJdkProxy(userDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();
    }
}
