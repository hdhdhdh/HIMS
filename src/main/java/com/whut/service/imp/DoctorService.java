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

    @Override
    public Doctor findDoctorById(String d_id) {
        return iDoctorDao.findDoctorById(d_id);
    }

    @Override
    public List<Doctor> findDoctor() {
        return iDoctorDao.findDoctor();
    }

    @Override
    public List<Doctor> findAllDoctor() {
        return iDoctorDao.findAllDoctor();
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        try {
            iDoctorDao.addDoctor(doctor);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
