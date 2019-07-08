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
            iPrescriptionDao.addPrescription(prescription.getC_id(),prescription.getM_id());
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean deletePrescription(Prescription prescription) {
        return false;
    }

    public boolean deletePrescription(int c_id,String m_id)
    {
        try {
            iPrescriptionDao.deletePrescription(c_id,m_id);
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
            iPrescriptionDao.addPrescription(c_id,medicine.getM_id());
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean addMedicineList(String c_id, String m_list)
    {
        try {
            int c = Integer.parseInt(c_id);
            String[] m_array = m_list.split("%");
            for (String m_id:m_array)
            {
                System.out.println(c+" "+m_id);
                if(m_id.equals("") == false)
                {

                    iPrescriptionDao.addPrescription(c,m_id);
                }

            }
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

}
