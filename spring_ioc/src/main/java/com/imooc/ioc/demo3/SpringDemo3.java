package com.imooc.ioc.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的作用域范围测试
 */
public class SpringDemo3 {
    @Test
    public void demo1() {
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person1 = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");

        System.out.println(person1);
        System.out.println(person2);
    }

    @Test
    public void demo2() {
        //创建工厂
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Man man = (Man) applicationContext.getBean("man");

        man.run();

        applicationContext.close();
    }

    @Test
    public void demo3() {
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        userDao.findAll();
        userDao.update();
        userDao.save();
        userDao.delete();
    }

}
