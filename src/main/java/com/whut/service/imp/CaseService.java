package com.whut.service.imp;

import com.whut.bean.Case;
import com.whut.dao.ICaseDao;
import com.whut.service.ICaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService implements ICaseService {
    @Autowired
    public ICaseDao iCaseDao;
    @Override
    public List<Case> findCase() {
        return iCaseDao.findCase();
    }

    @Override
    public void deleteCase(int c_id) {
        iCaseDao.deleteCase(c_id);
    }

    @Override
    public void addCase(Case c_case) {
        iCaseDao.addCase(c_case);
    }
}
