package com.whut.dao;

import com.whut.bean.Appointment;
import com.whut.bean.Case;

import java.util.List;

public interface IAppointmentDao
{
    public List<Appointment> getAppointmentByUserId(String p_id);
    public Appointment getUnprocessedAppointmentByUserId(String p_id);
    public void addAppointment(Appointment appointment);
    public List<Appointment> getAllAppointment();//得到所有预约
    public Appointment getAppointmentById(String pr_id);
    public void updateAppointment(Appointment type);
    public void deleteAppointment(String pr_id);
    public void updateAppointmentStatus(Appointment appointment);//医生更新预约状态
    public List<Appointment> getUnprocessedAppointment(int a_status);//得到未处理的预约信息
    public List<Appointment> getProcessedAppointment(int a_status);//得到已处理的预约信息
}
