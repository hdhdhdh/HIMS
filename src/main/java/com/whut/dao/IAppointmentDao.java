package com.whut.dao;

import com.whut.bean.Appointment;
import com.whut.bean.Department;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.Date;
import java.util.List;

public interface IAppointmentDao
{
    public List<Appointment> getAppointmentByUserId(String p_id);
    public void addAppointment(Appointment appointment);
    public List<Appointment> getAllAppointment();//得到所有预约
    public Appointment getAppointmentById(String pr_id);
    public void updateAppointment(Appointment type);
    public void deleteAppointment(String pr_id);
    public void updateAppointmentStatus(@Param("a_id") int a_id);//医生更新预约状态
    public List<Appointment> getAllUnprocessedAppointment(@Param("dp_id") String dp_id);//得到未处理的预约信息
    public List<Appointment> getProcessedAppointment(@Param("dp_id") String dp_id);//得到已处理的预约信息
    public List<Appointment> getUnprocessedAppointmentBeforTheDay(@Param("dp_id") String dp_id , @Param("day") Date day);//得到已处理的预约信息
    public Appointment getUnprocessedAppointmentByUserId(String p_id);
    public Appointment getPatientAppointmentById(@Param("p_id") String p_id);  /*病人得到ziji预约记录*/
}
