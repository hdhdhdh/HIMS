package com.whut.service;


import com.whut.bean.Department;
import com.whut.bean.Patient;
import com.whut.bean.Patient;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.List;

public interface IPatientService
{
    public boolean patientLogin(Patient patient);//病人登录检查
    public boolean addPatient(Patient patient);//添加病人
    public Patient patientCheckLogin(String p_id,String p_password);//病人登录检查
    public List<Patient> getAllPatient();//获取所有病人
    public Patient getPatientById(String p_id);//根据id获取病人
    public boolean updatePatient(Patient patient);//更新病人信息
    public boolean deletePatient(String p_id);//删除病人
}
