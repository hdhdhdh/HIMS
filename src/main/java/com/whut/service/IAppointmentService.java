package com.whut.service;

import com.whut.bean.Appointment;

import java.util.List;

public interface IAppointmentService {
    public boolean addAppointment(String p_id, String dp_id);
    public List<Appointment> getAllAppointment();//导出所有预约
    public Appointment getAppointmentById(String a_id);
    public boolean addAppointment(Appointment appointment);
    public boolean updateAppointment(Appointment appointment);
    public boolean deleteAppointment(String a_id);
    public boolean updateAppointmentStatus(Appointment appointment);
    public List<Appointment> getUnprocessedAppointment(int a_status);//得到未处理的预约信息
    public List<Appointment> getProcessedAppointment(int a_status);//得到已处理的预约信息
}
