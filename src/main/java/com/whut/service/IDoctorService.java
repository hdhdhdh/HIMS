package com.whut.service;

import com.whut.bean.Case;
import com.whut.bean.Doctor;
import com.whut.bean.Doctor;

import javax.ws.rs.GET;
import java.util.List;

public interface IDoctorService
{

    public Doctor getDoctorById(String d_id);//通过id得到医生信息
    public boolean updateDoctorWithoutId(Doctor doctor);//医生更改自己的个人信息



}
