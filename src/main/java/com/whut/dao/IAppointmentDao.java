package com.whut.dao;

import com.whut.bean.Appointment;

import java.util.List;

public interface IAppointmentDao
{
    public List<Appointment> getAppointmentByUserId();

}
