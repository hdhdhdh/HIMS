package com.whut.dao;

import com.whut.bean.Appointment;
import com.whut.bean.Case;
import com.whut.bean.Department;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    public void updateAppointmentStatus(@Param("d_id") String d_id);//医生更新预约状态
    public List<Appointment> getAllUnprocessedAppointment(@Param("d_id") String d_id);//得到未处理的预约信息
    public List<Appointment> getProcessedAppointment(@Param("d_id") String d_id);//得到已处理的预约信息
    public List<Appointment> getUnprocessedAppointmentBeforTheDay(@Param("d_id") String d_id , @Param("day") Date day);//得到已处理的预约信息
}
