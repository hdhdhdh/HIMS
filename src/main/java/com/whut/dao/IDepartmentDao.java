package com.whut.dao;

import com.whut.bean.Department;

import java.util.List;

public interface IDepartmentDao
{
    List<Department> getDepartment();
    void addDepartment(Department department);
    void deleteDepartment();
    void updateDepartment(Department department);
    Department getDepartmentById(String id);
}
