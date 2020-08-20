package com.hosdep.dao;

import com.hosdep.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public interface CategoryDao {
    void insert(Category category);

    void update(Category category);

    void delete(Integer id);

    Category selectById(Integer id);

    List<Category> selectAll();
}
