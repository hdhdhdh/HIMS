package com.whut.dao;

import com.whut.bean.Type;

import java.util.List;

public interface ITypeDao {
    List<Type> findType();
    void addType();
    void deleteType();
    void updateType();
    Type findTypeById(String id);
}
