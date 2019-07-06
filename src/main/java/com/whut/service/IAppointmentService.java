package com.whut.service;

import com.whut.bean.Appointment;

import java.util.Date;
import java.util.List;

public interface IAppointmentService {
    public boolean addAppointment(String p_id, String dp_id);

    public List<Appointment> getAllAppointment();//获取所有预约 未使用
    public Appointment getAppointmentById(String a_id);//通过id获取预约 未使用
    public boolean addAppointment(Appointment appointment);//添加预约
    public boolean updateAppointment(Appointment appointment);//更新整个预约 未使用
    public boolean deleteAppointment(String a_id);//通过id删除预约 使用
    public boolean updateAppointmentStatus(int d_id);//更新预约的状态,直接完成预约处理
    public boolean checkDoctorPermissionForDiagnosis(String dp_id, String p_id);//检查医生诊治的/权限
    public List<Appointment> getAllUnprocessedAppointment(String d_id);//得到本部门所有未处理的预约信息
    public List<Appointment> getProcessedAppointment(String d_id);//得到本部门已处理的预约信息
    public List<Appointment> getUnprocessedAppointmentBeforTheDay(String d_id , Date day);//根据日期获取未处理的预约
    public List<Appointment> getAUnprocessedAppointmentList(String dp_id,String type);//获取本部门未处理的预约按日期筛选
}
