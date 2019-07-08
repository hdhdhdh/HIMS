package com.whut.service;

import com.whut.bean.Case;
import com.whut.bean.Doctor;
import com.whut.bean.Doctor;
import com.whut.bean.Patient;

import javax.ws.rs.GET;
import java.util.List;

public interface IDoctorService
{

    List<Doctor> getAllDoctor();// 病人获取所有医生

    List<Doctor> getAllDoctor(int page,int size);//管理员导出所有医生信息

    public void deleteDoctor(String id);// 删除医生
    public Doctor doctorCheckLogin(String d_id,String d_password);//医生登录检查

    public boolean addDoctor(Doctor doctor);// 添加医生

    public Doctor getDoctorById(String d_id);//根据id获取医生信息
    public boolean updateDoctorWithoutId(Doctor doctor);//医生更新自己的信息
    public boolean doctorLogin(Doctor doctor);//医生登录检查


    public String updateDoctor(Doctor doctor); // 更新医生信息 不明

    Doctor queryDoctorById(String id);//根据id获取医生信息

    boolean updateDoctorTitleAndDescription(Doctor doctor); //更新医生的title 和 description
}
