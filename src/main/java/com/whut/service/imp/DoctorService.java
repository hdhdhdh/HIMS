package com.whut.service.imp;

import com.whut.bean.Doctor;
import com.whut.dao.IDoctorDao;
import com.whut.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {
    @Autowired
    public IDoctorDao iDoctorDao;
    @Override
    public boolean updateDoctor(Doctor doctor)
    {
        try
        {
            iDoctorDao.updateDoctor(doctor);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
