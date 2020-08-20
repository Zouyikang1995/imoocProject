package com.hosdep.service.impl;

import com.hosdep.dao.CategoryDao;
import com.hosdep.entity.Category;
import com.hosdep.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public void add(Category category) {
        categoryDao.insert(category);
    }

    public void remove(Integer id) {
        categoryDao.delete(id);
    }

    public void edit(Category category) {
        categoryDao.update(category);
    }

    @Override
    public Category get(Integer id) {
        return categoryDao.selectById(id);
    }

    public List<Category> getAll() {
        return categoryDao.selectAll();
    }
}
