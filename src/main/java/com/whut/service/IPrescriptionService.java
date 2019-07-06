package com.whut.service;

import com.whut.bean.Medicine;
import com.whut.bean.Prescription;

import java.util.List;

public interface IPrescriptionService
{
    public List<Prescription> getPrescriptionByCaseId(int c_id);//根据病例获取id药物使用记录
    public boolean addPrescription(Prescription prescription);//添加药物使用记录
    public boolean deletePrescription(Prescription prescription);//删除药物使用记录
    public boolean addMedicineToPrescription(int c_id, Medicine medicine);//添加药物使用记录
}
