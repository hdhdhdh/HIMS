package com.whut.service;

import com.whut.bean.Case;

import java.util.List;

public interface ICaseService
{
    public List<Case> getAllCase();
    public Case getCaseById(String c_id);
    public boolean addCase(Case icase);
    public boolean updateCase(Case icase);
    public boolean deleteCase(int c_id);
}
