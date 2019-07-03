package com.whut.dao;


import com.whut.bean.Case;

import java.util.List;

public interface ICaseDao {
    public List<Case> getAllCase();
    public Case getCaseById(int c_id);
    public void addCase(Case type);
    public void updateCase(Case type);
    public void deleteCase(int c_id);
    
}
