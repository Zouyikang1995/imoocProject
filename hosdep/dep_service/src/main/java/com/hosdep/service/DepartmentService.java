package com.hosdep.service;

import com.hosdep.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);

    void remove(Integer id);

    void edit(Department department);

    Department get(Integer id);

    List<Department> getDepartmentByCategory(Integer categoryId);

    List<Department> getAll();
}
