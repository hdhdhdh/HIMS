package com.whut.service.imp;

import com.whut.bean.Department;
import com.whut.bean.Patient;
import com.whut.dao.IAppointmentDao;
import com.whut.dao.IDepartmentDao;
import com.whut.dao.IPatientDao;
import com.whut.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService
{
    @Autowired
    private IPatientDao iPatientDao;
    @Autowired
    private IAppointmentDao iAppointmentDao;
    @Autowired
    private IDepartmentDao iDepartmentDao;
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

    @Override
    public Patient patientCheckLogin(String p_id, String p_password) //返回对象的登录
    {
        Patient patient1 = iPatientDao.getPatientById(p_id);
        if(patient1 == null || patient1.getP_password().equals(p_password) == false)
            return null;
        return patient1;
    }

    @Override
    public List<Patient> getAllPatient() {
        return null;
    }

    @Override
    public Patient getPatientById(String p_id) {
        return null;
    }

    @Override
    public boolean updatePatient(Patient patient) {
        return false;
    }

    @Override
    public boolean deletePatient(String p_id) {
        return false;
    }


}
