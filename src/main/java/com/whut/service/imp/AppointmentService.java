package com.whut.service.imp;

import com.whut.dao.IAppointmentDao;
import com.whut.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService implements IAppointmentService
{
    @Autowired
    IAppointmentDao iAppointmentDao;
    @Override
    public boolean addAppointment(String p_id, String dp_id)
    {
        try {
            iAppointmentDao.addAppointment(p_id,dp_id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
