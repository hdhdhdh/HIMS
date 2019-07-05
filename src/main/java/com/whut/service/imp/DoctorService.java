package com.whut.service.imp;

import com.github.pagehelper.PageHelper;
import com.whut.bean.Case;
import com.whut.bean.Doctor;
import com.whut.dao.ICaseDao;
import com.whut.dao.IDoctorDao;
import com.whut.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {
    @Autowired
    public IDoctorDao iDoctorDao;

    public boolean updateDoctorWithoutId(Doctor doctor)
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

    @Override
    public boolean doctorLogin(Doctor doctor)
    {

        Doctor doctor1 = iDoctorDao.getDoctorById(doctor.getD_id());
        if (doctor1 != null && doctor.getD_password().equals(doctor1.getD_password()))
            return true;
        return false;
    }

    @Override
    public void deleteDoctor(String id) {
        iDoctorDao.deleteDoctor(id);
    }

    public Doctor getDoctorById(String d_id)
    {
        return iDoctorDao.getDoctorById(d_id);
    }


    /**
     * 获取所有doctor   ---崔佳豪
     * @return
     */
    public List<Doctor> getAllDoctor(){

        return iDoctorDao.getAllDoctor();
    }

    @Override
    public List<Doctor> findAllDoctor(int page, int size) {
        PageHelper.startPage(page,size);
        return iDoctorDao.findAllDoctor(page,size);
    }


    /*

    @Autowired
    public IDoctorDao DocService;
    */
    /*

    @Override
    public void deleteDoctor(String id) {
        DocService.deleteDoctor(id);
    }
    */

    @Override
    public String addDoctor(Doctor doctor) {
        return iDoctorDao.addDoctor(doctor);
    }

    @Override
    public String updateDoctor(Doctor doctor) {
        return iDoctorDao.updateDoctor(doctor);
    }

    @Override
    public Doctor queryDoctorById(String id) {
        return iDoctorDao.queryDoctorById(id);
    }



}
