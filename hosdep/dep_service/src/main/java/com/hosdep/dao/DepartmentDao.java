package com.hosdep.dao;


import com.hosdep.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);

    void update(Department department);

    void delete(Integer id);

    Department selectById(Integer id);

    List<Department> selectByCategoryId(Integer id);

    List<Department> selectAll();
}
