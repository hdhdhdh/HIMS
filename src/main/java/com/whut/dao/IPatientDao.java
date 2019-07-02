package com.whut.dao;

import com.whut.bean.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPatientDao
{
    public Patient getPatientById(@Param("p_id")String p_id);
    public void addPaient(Patient patient);
}
