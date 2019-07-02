package com.whut.dao;

import com.whut.bean.Appointment;

import java.util.List;

public interface IAppointmentDao
{
    public List<Appointment> getAppointmentByUserId(String p_id);
    public Appointment getUnprocessedAppointmentByUserId(String p_id);
    public void addAppointment(String p_id,String dp_id);

}
