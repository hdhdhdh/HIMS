package com.whut.service;

import com.whut.bean.Department;
import com.whut.bean.Department;
import com.whut.bean.Doctor;

import java.util.List;

public interface IDepartmentService {
    public List<Department> getAllDepartment();

    public List<Department> getAllDepartment(int page, int size);

    public Department getDepartmentById(String dp_id);
    public boolean addDepartment(Department department);
    public boolean updateDepartment(Department department);
    public boolean deleteDepartment(String dp_id);
}
