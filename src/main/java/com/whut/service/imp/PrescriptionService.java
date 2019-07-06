package com.whut.service.imp;

import com.whut.bean.Medicine;
import com.whut.bean.Prescription;
import com.whut.dao.IPrescriptionDao;
import com.whut.service.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService implements IPrescriptionService
{
    @Autowired
    IPrescriptionDao iPrescriptionDao;
    public List<Prescription> getPrescriptionByCaseId(int c_id)
    {
        return iPrescriptionDao.getPrescriptionByCaseId(c_id);
    }

    public boolean addPrescription(Prescription prescription)
    {
        try {
            iPrescriptionDao.addPrescription(prescription);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    public boolean deletePrescription(Prescription prescription)
    {
        try {
            iPrescriptionDao.deletePrescription(prescription);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean addMedicineToPrescription(int c_id, Medicine medicine)
    {
        Prescription prescription = new Prescription();
        prescription.setC_id(c_id);
        prescription.setM_id(medicine.getM_id());
        prescription.setM_name(medicine.getM_name());
        try {
            iPrescriptionDao.addPrescription(prescription);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

}
