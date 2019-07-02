package com.whut.service;

import com.whut.bean.Department;
import com.whut.bean.Department;

import java.util.List;

public interface IDepartmentService {
    public List<Department> getAllDepartment();
    public Department getDepartmentById(String dp_id);
    public boolean addDepartment(Department department);
    public boolean updateDepartment(Department department);
    public boolean deleteDepartment(String dp_id);
}
