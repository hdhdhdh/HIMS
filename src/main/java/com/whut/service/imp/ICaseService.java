package com.whut.service.imp;

import com.whut.bean.Case;

import java.util.List;

public interface ICaseService {
    List<Case> findCase();//查找病例
    void deleteCase(int c_id);//删除病例
    void addCase(Case c_case);//增加病例
}
