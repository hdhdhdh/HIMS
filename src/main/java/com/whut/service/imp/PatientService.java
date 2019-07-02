package com.whut.service.imp;

import com.whut.bean.Patient;
import com.whut.dao.IPatientDao;
import com.whut.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService
{
    @Autowired
    private IPatientDao iPatientDao;
    @Override
    public boolean patienLogin(Patient patient)
    {
        Patient patient1 = iPatientDao.getPatientById(patient.getP_id());
        if(patient1 == null || !patient1.getP_password().equals(patient.getP_password()))
            return false;
        return true;
    }
}
