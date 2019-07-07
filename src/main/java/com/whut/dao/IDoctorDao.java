package com.whut.dao;

import com.whut.bean.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDoctorDao {
    List<Doctor> getAllDoctor();//病人导出所有医生信息
    void deleteDoctor(String d_id);//删除医生信息

    void addDoctor(Doctor doctor);//增加医生

    List<Doctor> getAllDoctor(int page,int size);//管理员导出所有医生信息

    void updateDoctorWithoutId(Doctor doctor);//医生更新医生信息
    void updateDoctorWithId(@Param("newDoctor") Doctor newDoctor,  @Param("target") String target);//管理员更新医生信息
    Doctor getDoctorById(String d_id);//查找医生的id
    Doctor doctorLogin(String d_id,String d_password);
    public String updateDoctor(Doctor doctor);
    Doctor queryDoctorById(String id);
    void updateDoctorTitleAndDescription(Doctor doctor);    //更新医生title 和 description
}
