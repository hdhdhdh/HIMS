package com.whut.dao;

import com.whut.bean.Patient;

import java.util.List;

public interface IPatientDao
{
    public Patient getPatientById(String p_id);
    public void addPaient(Patient patient);
}
