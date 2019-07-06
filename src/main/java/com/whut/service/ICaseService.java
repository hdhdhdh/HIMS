package com.whut.service;

import com.whut.bean.Case;
import com.whut.bean.UncheckoutPrescription;

import java.util.List;

public interface ICaseService
{
    public List<Case> getAllCase();
    public Case getCaseById(int c_id);
    public boolean addCase(Case icase);
    public boolean updateCaseSataus(int c_id,int c_status);
    public boolean updateCase(Case icase);
    public boolean deleteCase(int c_id);
    public List<Case> getCaseByPatientId(String p_id);//通过病人的id查找病人的病例
    public boolean checkDoctorPermissionForPrescribe(String d_id, int c_id);
    public boolean checkPermissionForCheckout(int c_id);
    public List<Case> getUnprescribedCase(String d_id);
    public List<Case> getUncheckoutCaseByPatientId(String p_id);
    public List<UncheckoutPrescription> getUncheckoutPrescription(String p_id);
}
