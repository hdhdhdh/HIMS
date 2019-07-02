package com.whut.service;

import com.whut.bean.Case;

import java.util.List;

public interface ICaseService
{
    public List<Case> getAllCase();
    public Case getCaseById(String c_id);
    public boolean addCase(Case ncase);
    public boolean updateCase(Case ncase);
    public boolean deleteCase(String c_id);
}
