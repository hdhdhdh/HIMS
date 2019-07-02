package com.whut.dao;

import com.whut.bean.Doctor;

import java.util.List;

public interface IDoctorDao {
    List<Doctor> findDoctor();//导出该医生信息
    List<Doctor> findAllDoctor();//导出所有医生信息
    void deleteDoctor(String d_id);//删除医生信息
    void addDoctor(Doctor doctor);//增加医生
    void updateDoctor(Doctor doctor);//医生更新医生信息
    void Mea_updateDoctor(Doctor doctor,String d_id);//管理员更新医生信息
    Doctor findDoctorById(String d_id);//查找医生的id

}
