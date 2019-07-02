package com.whut.service;

import com.whut.bean.Type;
import com.whut.bean.Type;
import com.whut.bean.Type;

import java.util.List;

public interface ITypeService
{
    public List<Type> getAllType();
    public Type getTypeById(String t_id);
    public boolean addType(Type type);
    public boolean updateType(Type type);
    public boolean deleteType(String t_id);
}
