package com.whut.service;

import com.whut.bean.Appointment;

import java.util.List;

public interface IAppointmentService {
    public boolean addAppointment(String p_id, String dp_id);
    public List<Appointment> getAllAppointment();
    public Appointment getAppointmentById(String a_id);
    public boolean addAppointment(Appointment appointment);
    public boolean updateAppointment(Appointment appointment);
    public boolean deleteAppointment(String a_id);
}
