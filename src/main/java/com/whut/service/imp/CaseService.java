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
    public List<Case> getAllCase() {
        return null;
    }

    @Override
    public Case getCaseById(String c_id) {
        return null;
    }

    @Override
    public boolean addCase(Case icase) {
        try
        {
            iCaseDao.addCase(icase);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCase(Case icase) {
        return false;
    }

    @Override
    public boolean deleteCase(int c_id) {

        try
        {
            iCaseDao.deleteCase(c_id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
