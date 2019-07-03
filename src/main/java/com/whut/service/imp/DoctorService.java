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
    public boolean updateDoctor(Doctor doctor)
    {
        try
        {
            iDoctorDao.updateDoctorWithoutId(doctor);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteDoctor(String d_id) {
        return false;
    }

    public Doctor getDoctorById(String d_id) {
        return iDoctorDao.getDoctorById(d_id);
    }

    @Override
    public boolean updateDoctorWithoutId(Doctor doctor) {
        return false;
    }

    public List<Doctor> getAllDoctor() {
        return iDoctorDao.getAllDoctor();
    }



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
