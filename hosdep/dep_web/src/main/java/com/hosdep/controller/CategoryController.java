package com.hosdep.controller;

import com.hosdep.entity.Category;
import com.hosdep.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 科室分类控制类
 */
@Controller("categoryController")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //  /category/list.do      category.jsp
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.getAll();
        request.getServletContext().setAttribute("CLIST", categoryList);
        request.getRequestDispatcher("../category.jsp").forward(request, response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../category_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Category category = new Category();
        category.setName(name);
        categoryService.add(category);

        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.get(id);
        request.setAttribute("OBJ", category);
        request.getRequestDispatcher("../category_edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Category category = new Category();
        category.setId(id);
        category.setName(name);

        categoryService.edit(category);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        categoryService.remove(id);
        response.sendRedirect("list.do");
    }

}
