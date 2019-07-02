package com.whut.dao;


import com.whut.bean.Case;

import java.util.List;

public interface ICaseDao {
    public List<Case> getAllCase();
    public Case getCaseById(String pr_id);
    public void addCase(Case type);
    public void updateCase(Case type);
    public void deleteCase(String pr_id);
    
}
