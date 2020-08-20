package com.hosdep.controller;

import com.hosdep.entity.Category;
import com.hosdep.entity.Department;
import com.hosdep.service.CategoryService;
import com.hosdep.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 科室管理控制类
 */
@Controller("departmentController")
public class DepartmentController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    DepartmentService departmentService;

    //   /department/list.do     department.jsp

    /**
     * 科室分类多次使用，将科室分类存入上下文全局对象，减少对数据库的查询
     * 在前台界面，登录跳转主界面，以及科室分类主界面三个地方进行全局对象更改
     * 利用监听器可以更简单处理问题，但由于监听器不属于spring管理，无法将categoryService进行注入
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.getAll();
        request.getServletContext().setAttribute("CLIST", categoryList);
        List<Department> departmentList = departmentService.getAll();
        request.setAttribute("DLIST", departmentList);
        request.getRequestDispatcher("../department.jsp").forward(request, response);
    }

    public void detailByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        List<Department> departmentByCategory = departmentService.getDepartmentByCategory(categoryId);
        request.setAttribute("DLIST", departmentByCategory);
        //List<Category> categoryList = categoryService.getAll();
        //request.setAttribute("CLIST", categoryList);
        request.getRequestDispatcher("../department.jsp").forward(request, response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //List<Category> categoryList = categoryService.getAll();
        //request.setAttribute("CLIST", categoryList);
        request.getRequestDispatcher("../department_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Department department = new Department();
        department.setName(name);
        department.setCategoryId(categoryId);
        departmentService.add(department);

        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Department department = departmentService.get(id);
        request.setAttribute("OBJ", department);
        //List<Category> categoryList = categoryService.getAll();
        //request.setAttribute("CLIST", categoryList);
        request.getRequestDispatcher("../department_edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Department department = new Department();
        department.setId(id);
        department.setName(name);
        department.setCategoryId(categoryId);

        departmentService.edit(department);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        departmentService.remove(id);
        response.sendRedirect("list.do");
    }

}
