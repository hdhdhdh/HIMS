package com.whut.dao;

import com.whut.bean.Type;

import java.util.List;

public interface ITypeDao {
    List<Type> getType();
    void addType(Type type);
    void deleteType(String t_id);
    void updateType(Type type);
    Type getTypeById(String t_id);
}
