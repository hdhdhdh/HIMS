package com.whut.service;

import com.whut.bean.Doctor;
import com.whut.bean.Doctor;

import java.util.List;

public interface IDoctorService
{
    public List<Doctor> getAllDoctor();
    public Doctor getDoctorById(String d_id);
    public boolean addDoctor(Doctor doctor);
    public boolean updateDoctor(Doctor doctor);
    public boolean deleteDoctor(String d_id);
}
