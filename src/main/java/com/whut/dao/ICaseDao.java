package com.whut.dao;


import com.whut.bean.Case;
import com.whut.bean.Doctor;
import org.apache.ibatis.annotations.Param;

import javax.swing.*;
import javax.xml.ws.soap.Addressing;
import java.util.List;

public interface ICaseDao {
    public List<Case> getAllCase();//导出所有病例
    public Case getCaseById(int c_id);//通过病例号得到病例
    public void addCase(Case icase);//增加病例
    public void updateCase(Case icase);//更新病例
    public void deleteCase(int c_id);//删除病例
    public boolean updateCaseSataus(@Param("c_id") int c_id,@Param("c_status") int c_status);
    public List<Case> getCaseByPatientId(String p_id);//通过病人id得到病例
    public void addPrescription(@Param(" c_id") int  c_id, @Param("prescription") String prescription);
    public List<Case> getUnprescribedCase(@Param("d_id") String d_id);
    public List<Case> getUncheckouCaseByPatientId (@Param("p_id") String p_id);
    public List<Case> getUnpayedCaseByPatientId (@Param("p_id") String p_id);
}
