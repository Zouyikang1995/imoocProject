package com.hosdep.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 核心控制类：解析请求路径，反射到各控制类和方法
 */
public class DispatcherServlet extends GenericServlet {
    private ApplicationContext context;

    public void init() throws ServletException {
        super.init();
        context = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        /**
         *      请求种类一：只有一级路径，在selfController统一类下
         *      /login.do
         *      请求种类二：
         *      /department/add.do
         *      departmentController
         *      public void add(HttpServletRequest request,HttpServletResponse response){}
         */
        String path = request.getServletPath().substring(1);
        /**
         *      处理后结果：
         *      login.do
         *      department/add.do
         */
        String beanName = null;
        String methodName = null;
        int index = path.indexOf('/');
        if (index != -1) {
            beanName = path.substring(0, index) + "Controller";
            methodName = path.substring(index + 1, path.indexOf(".do"));
        }else {
            beanName = "selfController";
            methodName = path.substring(0, path.indexOf(".do"));
        }

        Object obj = context.getBean(beanName);
        try {
            Method method = obj.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(obj, request, response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
