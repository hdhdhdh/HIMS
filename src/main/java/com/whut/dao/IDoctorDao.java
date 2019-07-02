package com.whut.dao;

import com.whut.bean.Doctor;

import java.util.List;

public interface IDoctorDao {
    List<Doctor> findDoctor();
    void deleteDoctor(String d_id);
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    Doctor findDoctorById(String d_id);
}
