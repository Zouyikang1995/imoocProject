package com.imooc.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3 {
    @Test
    public void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProductService productService = (ProductService) applicationContext.getBean("productService");

        productService.save();
    }

    @Test
    public void demo2() {
        ProductDao productDao = new ProductDao();

        ProductDao proxy = (ProductDao) new MyCglibProxy(productDao).creatProxy();

        proxy.save();
        proxy.update();;
        proxy.delete();
        proxy.find();
    }
}
