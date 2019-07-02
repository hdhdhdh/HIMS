package com.whut.service;

import com.whut.bean.Prescription;

import java.util.List;

public interface IPrescriptionService
{
    public List<Prescription> getAllPrescription();
    public Prescription getPrescriptionById(String pr_id);
    public void addPrescription(Prescription type);
    public void updatePrescription(Prescription type);
    public void deletePrescription(String pr_id);
}
