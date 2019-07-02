package com.whut.service;

import com.whut.bean.Doctor;

import java.util.List;

public interface IDoctorService
{
    public boolean updateDoctor(Doctor doctor);//医生更新医生信息
    Doctor findDoctorById(String d_id);//查找医生的id
    List<Doctor> findDoctor();//导出该医生信息
    List<Doctor> findAllDoctor();//导出所有医生信息
    boolean addDoctor(Doctor doctor);//增加医生
}
