package com.hosdep.service.impl;

import com.hosdep.dao.DepartmentDao;
import com.hosdep.entity.Department;
import com.hosdep.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public void add(Department department) {
        departmentDao.insert(department);
    }

    @Override
    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    @Override
    public void edit(Department department) {
        departmentDao.update(department);
    }

    @Override
    public Department get(Integer id) {
        return departmentDao.selectById(id);
    }

    @Override
    public List<Department> getDepartmentByCategory(Integer categoryId) {
        return departmentDao.selectByCategoryId(categoryId);
    }

    @Override
    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
