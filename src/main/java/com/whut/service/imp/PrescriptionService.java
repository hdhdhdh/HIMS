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

    public boolean addPrescription(Prescription prescription)
    {
        try {
            iPrescriptionDao.addPrescription(prescription);
            return  true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return  false;
        }

    }

    public boolean updatePrescription(Prescription prescription)
    {

        try {
            iPrescriptionDao.updatePrescription(prescription);
            return  true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return  false;
        }
    }

    public boolean deletePrescription(String pr_id)
    {

        try {
            iPrescriptionDao.deletePrescription(pr_id);
            return  true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return  false;
        }
    }

}
