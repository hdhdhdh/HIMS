package com.whut.dao;

import com.whut.bean.Prescription;

import java.util.List;

public interface IPrescriptionDao 
{
    public List<Prescription> getAllPrescription();
    public Prescription getPrescriptionById(String pr_id);
    public void addPrescription(Prescription type);
    public void updatePrescription(Prescription type);
    public void deletePrescription(String pr_id);
}
