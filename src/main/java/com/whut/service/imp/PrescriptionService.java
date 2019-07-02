package com.whut.service.imp;

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
    public List<Prescription> getAllPrescription()
    {
        return iPrescriptionDao.getAllPrescription();
    }

    public Prescription getPrescriptionById(String pr_id)
    {
        return  iPrescriptionDao.getPrescriptionById(pr_id);
    }

    public void addPrescription(Prescription prescription)
    {
        iPrescriptionDao.addPrescription(prescription);
    }

    public void updatePrescription(Prescription prescription)
    {
        iPrescriptionDao.updatePrescription(prescription);
    }

    public void deletePrescription(String pr_id)
    {
        iPrescriptionDao.deletePrescription(pr_id);
    }

}
