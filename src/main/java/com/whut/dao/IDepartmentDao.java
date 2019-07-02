package com.whut.dao;

import com.whut.bean.Department;

import java.util.List;

public interface IDepartmentDao
{
    List<Department> findDepartment();
    void addDepartment();
    void deleteDepartment();
    void updateDepartment();
    Department findDepartmentById(String id);
}
