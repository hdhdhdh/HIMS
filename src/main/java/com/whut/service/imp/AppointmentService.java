package com.whut.service.imp;

import com.whut.bean.Appointment;
import com.whut.bean.Patient;
import com.whut.dao.IAppointmentDao;
import com.whut.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements IAppointmentService
{
    @Autowired
    IAppointmentDao iAppointmentDao;
    @Override
    public boolean addAppointment(String p_id, String dp_id)
    {
//        try {
//  //          iAppointmentDao.addAppointment(p_id,dp_id);
//            return true;
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//            return false;
//        }
        return false;
    }

    @Override
    public List<Appointment> getAllAppointment()
    {
        return iAppointmentDao.getAllAppointment();
    }

    @Override
    public Appointment getAppointmentById(String a_id) {
        return null;
    }

    @Override
    public boolean addAppointment(Appointment appointment)
    {
        try {
            iAppointmentDao.addAppointment(appointment);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateAppointment(Appointment appointment)
    {
        return false;
    }

    @Override
    public boolean deleteAppointment(String a_id)
    {
        return false;
    }

    @Override
    public boolean updateAppointmentStatus(Appointment appointment) {
        try
        {
            iAppointmentDao.updateAppointmentStatus(appointment);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Appointment> getUnprocessedAppointment(int a_status) {
        return iAppointmentDao.getUnprocessedAppointment(a_status);
    }

    @Override
    public List<Appointment> getProcessedAppointment(int a_status) {
        return iAppointmentDao.getProcessedAppointment(a_status);
    }

    @Override
    public List<Appointment> getUnprocessAppointmentByPId(String p_id) {
        return iAppointmentDao.getUnprocessedAppointmentByUserId(p_id);
    }
}
