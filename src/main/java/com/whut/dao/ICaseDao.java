package com.whut.dao;


import com.whut.bean.Case;

import javax.swing.*;
import java.util.List;

public interface ICaseDao {
    public List<Case> getAllCase();
    public Case getCaseById(int c_id);
    public void addCase(Case icase);
    public void updateCase(Case icase);
    public void deleteCase(int c_id);
    public List<Case> getCaseByPatientId(String p_id);
    
}
