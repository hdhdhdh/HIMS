package com.whut.dao;

import com.whut.bean.Department;

import java.util.List;

public interface IDepartmentDao
{
    List<Department> findDepartment();
    void addDepartment(Department department);
    void deleteDepartment(String dp_id);
    void updateDepartment(Department department);
    Department findDepartmentById(String dp_id);
}
