package com.whut.dao;


import com.whut.bean.Case;
import com.whut.bean.Doctor;
import org.apache.ibatis.annotations.Param;

import javax.swing.*;
import javax.xml.ws.soap.Addressing;
import java.util.List;

public interface ICaseDao {
    public List<Case> getAllCase();//导出所有病例 未使用
    public Case getCaseById(int c_id);//通过病例号得到病例
    public void addCase(Case icase);//增加病例
    public void updateCase(Case icase);//更新病例 未使用
    public void deleteCase(int c_id);//删除病例
    public boolean updateCaseSataus(@Param("c_id") int c_id,@Param("c_status") int c_status);//更新病例状态
    public List<Case> getCaseByPatientId(@Param("p_id") String p_id);//通过病人id得到病例
    public void addPrescription(@Param(" c_id") int  c_id, @Param("prescription") String prescription);//添加药物使用记录到Prescription表
    public List<Case> getUnprescribedCase(@Param("d_id") String d_id);//获取指定医生诊断但是未开处方的病例 1
    public List<Case> getUncheckouCaseByPatientId (@Param("p_id") String p_id);//获取指定病人未出库的病历 3
    public List<Case> getUnpayedCaseByPatientId (@Param("p_id") String p_id);//获取指定病人未支付的病例 2

    public List<Case> getHaveChechoutCaseByPatientId(@Param("p_id") String p_id);  //获取指定病人已出库的病例 4
}
