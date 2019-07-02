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
    public List<Doctor> findDoctor() {
        return iDoctorDao.findDoctor();
    }

    @Override
    public void deleteDoc(int d_id) {
        iDoctorDao.deleteDoc(d_id);
    }

    @Override
    public void addDoc(Doctor doctor) {
        iDoctorDao.addDoc(doctor);
    }

    @Override
    public void updateDoc(Doctor doctor) {
        iDoctorDao.updateDoc(doctor);
    }

    @Override
    public Doctor findId(int d_id) {
        return iDoctorDao.findId(d_id);
    }
}
