package com.whut.service;

import com.whut.bean.Case;

import java.util.List;

public interface ICaseService
{
    public List<Case> getAllCase();
    public Case getCaseById(int c_id);
    public boolean addCase(Case icase);
    public boolean updateCase(Case icase);
    public boolean deleteCase(int c_id);
    public List<Case> getCaseByPatientId(String p_id);//通过病人的id查找病人的病例
}
