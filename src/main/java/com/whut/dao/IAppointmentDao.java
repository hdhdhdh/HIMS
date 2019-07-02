package com.whut.dao;

import com.whut.bean.Appointment;

import java.util.List;

public interface IAppointmentDao
{
    public List<Appointment> getAppointmentByUserId(String p_id);
    public Appointment getUnprocessedAppointmentByUserId(String p_id);
    public void addAppointment(String p_id,String dp_id);
    public List<Appointment> getAllAppointment();
    public Appointment getAppointmentById(String pr_id);
    public void addAppointment(Appointment type);
    public void updateAppointment(Appointment type);
    public void deleteAppointment(String pr_id);

}
