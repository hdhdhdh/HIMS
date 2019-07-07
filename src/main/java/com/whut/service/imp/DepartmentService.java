package com.whut.service.imp;

import com.github.pagehelper.PageHelper;
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
        return iDepartmentDao.getDepartmentById(dp_id);
    }

    @Override
    public boolean addDepartment(Department department)
    {
        return false;
    }

    @Override
    public boolean updateDepartment(Department department)
    {
        return false;
    }

    @Override
    public boolean deleteDepartment(String dp_id)
    {
        return false;
    }

   @Override
    public List<Department> getAllDepartment(int page, int size){
       PageHelper.startPage(page,size);
       return iDepartmentDao.getAllDepartment(page,size);
   }

   }


