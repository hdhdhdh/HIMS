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
    public Case getCaseById(int c_id) {
        return null;
    }

    @Override
    public List<Case> getCaseByPatientId(String p_id) {
        return iCaseDao.getCaseByPatientId(p_id);
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
    public boolean checkDoctorPermissionForPrescribe(String d_id, int c_id)
    {
        Case mycase = iCaseDao.getCaseById(c_id);
        if (mycase != null && mycase.getD_id().equals(d_id))
        {
            return true;
        }else
        {
            return false;
        }
    }
    public boolean addPrescriptionToCase(int c_id,String prescription)
    {
        try {
            iCaseDao.addPrescription(c_id,prescription);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }
    public List<Case> getUnprescribedCase(String d_id)
    {
        return iCaseDao.getUnprescribedCase(d_id);
    }


}
