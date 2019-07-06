package com.whut.service.imp;

import com.whut.bean.Appointment;
import com.whut.bean.Case;
import com.whut.bean.Patient;
import com.whut.dao.IAppointmentDao;
import com.whut.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
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
        if (iAppointmentDao.getUnprocessedAppointmentByUserId(appointment.getP_id()) == null)
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

        return false;
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
    public boolean updateAppointmentStatus(int d_id) {
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
    public boolean checkDoctorPermissionForDiagnosis(String dp_id, String p_id)
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
    public List<Appointment> getAUnprocessedAppointmentList(String dp_id,String type)
    {
        List<Appointment> unprocessedAppointmentList;
        if(type == null)
        {
            unprocessedAppointmentList = new ArrayList<>();
        }else if(type.equals("all"))
        {
            unprocessedAppointmentList = iAppointmentDao.getAllUnprocessedAppointment(dp_id);
        }
        else
        {
            int days = 0;
            if(type.equals("today"))
            {
                days = 1;
            }else if(type.equals("threeday"))
            {
                days = 3;
            }
            else if(type.equals("week"))
            {
                days = 7;
            }
            else if(type.equals("month"))
            {
                days = 30;
            }
            if(days > 0)
            {
                Calendar ca = Calendar.getInstance();
                ca.add(Calendar.DATE,days);// num为增加的天数，可以改变的
                unprocessedAppointmentList = iAppointmentDao.getUnprocessedAppointmentBeforTheDay(dp_id,ca.getTime());
            }else
            {
                unprocessedAppointmentList = new ArrayList<>();
            }
        }
        return unprocessedAppointmentList;
    }


}
