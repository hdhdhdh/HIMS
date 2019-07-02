package com.whut.service.imp;

import com.whut.bean.Department;
import com.whut.dao.IDepartmentDao;
import com.whut.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService implements IDepartmentService
{
    @Autowired
    IDepartmentDao iDepartmentDao;
    public List<Department> getAllDepartment()
    {
        return iDepartmentDao.getAllDepartment();
    }
    public Department getDepartmentById(String dp_id)
    {
        return getDepartmentById(dp_id);
    }
}
