package com.whut.service;

import com.whut.bean.Prescription;

import java.util.List;

public interface IPrescriptionService
{
    public List<Prescription> getAllPrescription();
    public Prescription getPrescriptionById(String pr_id);
    public boolean addPrescription(Prescription prescription);
    public boolean updatePrescription(Prescription prescription);
    public boolean deletePrescription(String pr_id);
}
