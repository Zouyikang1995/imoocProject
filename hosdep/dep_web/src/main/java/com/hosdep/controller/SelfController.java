package com.hosdep.controller;

import com.hosdep.entity.Category;
import com.hosdep.entity.Department;
import com.hosdep.entity.User;
import com.hosdep.service.CategoryService;
import com.hosdep.service.DepartmentService;
import com.hosdep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 其它控制类，包括前台请求和后台登录控制
 */
@Controller("selfController")
public class SelfController {

    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    DepartmentService departmentService;

    //   /toLogin.do
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    //   /login.do
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.login(username, password);
        if (user == null) {
            response.sendRedirect("toLogin.do");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("USER", user);
            response.sendRedirect("/department/list.do");
        }
    }

    /**
     * 前台详情页面请求
     * /hospital.do         /WEB-INF/hospital.jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void hospital(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.getAll();
        request.getServletContext().setAttribute("CLIST", categoryList);
        List<Department> departmentList = departmentService.getAll();
        request.setAttribute("DLIST", departmentList);
        request.getRequestDispatcher("/WEB-INF/hospital.jsp").forward(request, response);
    }

}
