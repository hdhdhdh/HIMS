package com.whut.service;

import com.whut.bean.Case;
import com.whut.bean.UncheckoutPrescription;

import java.util.List;

public interface ICaseService
{
    public List<Case> getAllCase();//获取所有病例 未使用
    public Case getCaseById(int c_id);//根据id获取病例 未使用
    public boolean addCase(Case icase);//添加病例
    public boolean updateCaseSataus(int c_id,int c_status);//更新病例的status
    public boolean updateCase(Case icase);//更新整个病例 未使用
    public boolean deleteCase(int c_id);//删除病历 未使用
    public List<Case> getCaseByPatientId(String p_id);//通过病人的id查找病人的病例
    public boolean checkDoctorPermissionForPrescribe(String d_id, int c_id);//检查医生开处方的权限
    public boolean checkPermissionForCheckout(int c_id);//检查出库权限
    public List<Case> getUnprescribedCase(String d_id);//获取医生诊治但未开处方的病例
    public List<Case> getUncheckoutCaseByPatientId(String p_id);//获取该病人未出库的病例
    public List<UncheckoutPrescription> getUncheckoutPrescription(String p_id);//获取该病人未出库的病例中的处方信息
    public List<Case> getUncheckoutCase(String p_id);//获取该病人未出库的病例中的处方信息
    public List<Case> getUnpayedCaseByPatientId(String p_id);/* 通过病人id获取为缴费的病历单 */
    public List<Case> getHaveChechoutCaseByPatientId(String p_id); //通过病人id获取已经出库
    public boolean checkPermissionForPrescrb(String c_id, String d_id);
    //    public boolean checkDoctorPermissionForPrescribe(String d_id, int c_id);//检查医生开处方的权限
}

