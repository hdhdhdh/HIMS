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
    public Patient getPatienById(String p_id)
    {
        return iPatientDao.getPatienById(p_id);
    }
}
