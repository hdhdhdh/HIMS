package com.whut.dao;

import com.whut.bean.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDoctorDao {
    List<Doctor> getAllDoctor();//导出所有医生信息
    void deleteDoctor(String d_id);//删除医生信息
    void addDoctor(Doctor doctor);//增加医生
    void updateDoctorWithoutId(Doctor doctor);//医生更新医生信息
    void updateDoctorWithId(@Param("newDoctor") Doctor newDoctor,  @Param("target") String target);//管理员更新医生信息
    Doctor getDoctorById(String d_id);//查找医生的id
    Doctor doctorLogin(String d_id,String d_password);

}
