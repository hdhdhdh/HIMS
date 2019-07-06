package com.whut.service;

import com.whut.bean.Appointment;

import java.util.Date;
import java.util.List;

public interface IAppointmentService {
    public boolean addAppointment(String p_id, String dp_id);

    public List<Appointment> getAllAppointment();//导出所有预约
    public Appointment getAppointmentById(String a_id);
    public boolean addAppointment(Appointment appointment);
    public boolean updateAppointment(Appointment appointment);
    public boolean deleteAppointment(String a_id);
    public boolean updateAppointmentStatus(int d_id);
    public boolean checkDoctorPermissionForDiagnosis(String dp_id, String p_id);
    public List<Appointment> getAllUnprocessedAppointment(String d_id);//得到未处理的预约信息
    public List<Appointment> getProcessedAppointment(String d_id);//得到已处理的预约信息
    public List<Appointment> getUnprocessedAppointmentBeforTheDay(String d_id , Date day);
    public List<Appointment> getAUnprocessedAppointmentList(String dp_id,String type);
}
