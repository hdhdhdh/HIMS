package com.whut.service.imp;

import com.whut.bean.Type;
import com.whut.dao.ITypeDao;
import com.whut.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService
{
    @Autowired
    ITypeDao iTypeDao;
    public List<Type> getAllType()
    {
        return iTypeDao,getAllType();
    }

    public Type getTypeById(String t_id)
    {
        return  iTypeDao.getTypeById(t_id);
    }

    public boolean addType(Type type)
    {
        try {
            iTypeDao.addType(type);
            return true;
        }catch (Exception e)
        {
            return false;
        }

    }

    public boolean updateType(Type type)
    {
        try {
            iTypeDao.updateType(type)
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    public boolean deleteType(String pr_id)
    {
        ;
        try {
            iTypeDao.deleteType(pr_id);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

}
