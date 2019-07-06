package com.whut.service;

import com.whut.bean.Medicine;
import com.whut.bean.Prescription;

import java.util.List;

public interface IPrescriptionService
{
    public List<Prescription> getPrescriptionByCaseId(int c_id);
    public boolean addPrescription(Prescription prescription);
    public boolean deletePrescription(Prescription prescription);
    public boolean addMedicineToPrescription(int c_id, Medicine medicine);
}
