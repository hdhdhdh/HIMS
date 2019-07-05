package com.whut.service.imp;

import com.whut.bean.Appointment;
import com.whut.bean.Patient;
import com.whut.dao.IAppointmentDao;
import com.whut.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public boolean updateAppointmentStatus(String d_id) {
        try
        {
            iAppointmentDao.updateAppointmentStatus(d_id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Appointment> getAllUnprocessedAppointment(String d_id) {
        return iAppointmentDao.getAllUnprocessedAppointment(d_id);
    }


    @Override
    public List<Appointment> getProcessedAppointment(String d_id) {
      return iAppointmentDao.getProcessedAppointment(d_id);
    }
    public List<Appointment> getUnprocessedAppointmentBeforTheDay(String d_id , Date day)
    {
        return iAppointmentDao.getUnprocessedAppointmentBeforTheDay(d_id,day);
    }
    public boolean checkDoctorPermission(String dp_id,String p_id)
    {
        Appointment appointment = iAppointmentDao.getUnprocessedAppointmentByUserId(p_id);
        if (appointment != null && appointment.getDp_id().equals(dp_id))
        {
            return true;
        }else
        {
            return false;
        }
    }

    @Override
    public List<Appointment> getUnprocessAppointmentByPId(String p_id) {
        return iAppointmentDao.getUnprocessedAppointmentByUserId(p_id);
    }
}
