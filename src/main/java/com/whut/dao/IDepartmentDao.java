package com.whut.dao;

import com.whut.bean.Department;

import java.util.List;

public interface IDepartmentDao
{
    List<Department> getAllDepartment();
    void addDepartment(Department department);
    void deleteDepartment(String dp_id);
    void updateDepartment(Department department);
    Department getDepartmentById(String dp_id);
    List<Department> getAllDepartment(int page, int size);

}
