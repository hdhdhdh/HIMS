package com.whut.service;

import com.whut.bean.Case;
import com.whut.bean.Doctor;
import com.whut.bean.Doctor;
import com.whut.bean.Patient;

import javax.ws.rs.GET;
import java.util.List;

public interface IDoctorService
{
    // 病人获取所有医生
    List<Doctor> getAllDoctor();
    //管理员导出所有医生信息
    List<Doctor> getAllDoctor(int page,int size);
    // 删除医生
    public void deleteDoctor(String id);
    public Doctor doctorCheckLogin(String d_id,String d_password);
    // 添加医生
    public String addDoctor(Doctor doctor);

    public Doctor getDoctorById(String d_id);

    // 更新医生信息
    // 通过id得到医生信息
    // 医生更改自己的个人信息
    public boolean updateDoctorWithoutId(Doctor doctor);
    public boolean doctorLogin(Doctor doctor);

    // 更新医生信息
    public String updateDoctor(Doctor doctor);

    Doctor queryDoctorById(String id);
}
