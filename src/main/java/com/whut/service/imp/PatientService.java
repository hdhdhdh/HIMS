package com.whut.service.imp;

import com.whut.bean.Patient;
import com.whut.dao.IPatientDao;
import com.whut.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService
{
    @Autowired
    private IPatientDao iPatientDao;
    @Override
    public boolean patientLogin(Patient patient)
    {
        Patient patient1 = iPatientDao.getPatientById(patient.getP_id());
        if(patient1 == null || !patient1.getP_password().equals(patient.getP_password()))
            return false;
        return true;
    }
    @Override
    public boolean addPatient(Patient patient)
    {
        try {
            iPatientDao.addPaient(patient);
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }

}
