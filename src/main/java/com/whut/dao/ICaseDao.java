package com.whut.dao;


import com.whut.bean.Case;
import com.whut.bean.Doctor;

import javax.swing.*;
import java.util.List;

public interface ICaseDao {
    public List<Case> getAllCase();//导出所有病例
    public Case getCaseById(int c_id);//通过病例号得到病例
    public void addCase(Case icase);//增加病例
    public void updateCase(Case icase);//更新病例
    public void deleteCase(int c_id);//删除病例
    public List<Case> getCaseByPatientId(String p_id);//通过病人id得到病例

}
