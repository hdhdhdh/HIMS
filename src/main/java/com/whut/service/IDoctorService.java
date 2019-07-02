package com.whut.service;

import com.whut.bean.Doctor;

import java.util.List;

public interface IDoctorService {
    List<Doctor> findDoctor();//查找医生
    void deleteDoc(int d_id);//删除医生
    void addDoc(Doctor doctor);//增加医生
    void updateDoc(Doctor doctor);//更新医生
    Doctor findId(int d_id);//查找医生的id
}
