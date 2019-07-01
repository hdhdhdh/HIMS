package com.whut.dao;

import com.whut.bean.Doctor;

import java.util.List;

public interface IDoctorDao {
    List<Doctor> findDoctor();
    void deleteDoc(int d_id);
    void addDoc(Doctor doctor);
    void updateDoc(Doctor doctor);
    Doctor findId(int d_id);
}
