package com.whut.service.imp;

import com.whut.bean.Case;
import com.whut.bean.UncheckoutPrescription;
import com.whut.dao.ICaseDao;
import com.whut.enums.CaseStatusEnum;
import com.whut.service.ICaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return iCaseDao.getCaseById(c_id);
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
    public boolean updateCaseSataus(int c_id, int c_status)
    {
        try {
            iCaseDao.updateCaseSataus(c_id,c_status);
            return true;
        }catch (Exception e)
        {
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

        try
        {
            Case mycase = iCaseDao.getCaseById(c_id);
            if (mycase == null || mycase.getD_id().equals(d_id)||mycase.getC_status() == CaseStatusEnum.UNPRESCRIBED.getStatus())
            {
                return true;
            }else
            {
                return false;
            }
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean checkPermissionForCheckout(int c_id)
    {
        try {
            Case mycase = iCaseDao.getCaseById(c_id);
            if(mycase != null && mycase.getC_status() == CaseStatusEnum.UNCHECKOUT.getStatus())
                return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public boolean addPrescriptionToCase(int c_id,String prescription)
    {
        try {
            iCaseDao.addPrescription(c_id,prescription);
            //        iCaseDao.updateCaseSataus(c_id, CaseStatusEnum..getStatus());
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
    public List<Case> getUncheckoutCaseByPatientId(String p_id)
    {
        return iCaseDao.getUncheckouCaseByPatientId(p_id);
    }

    @Override
    public List<UncheckoutPrescription> getUncheckoutPrescription(String p_id)
    {
        List<UncheckoutPrescription> uncheckoutPrescriptions = new ArrayList<UncheckoutPrescription>();
        try {
            List<Case> cases = iCaseDao.getUncheckouCaseByPatientId(p_id);

            for (Case mycase:cases)
            {
                UncheckoutPrescription n = new UncheckoutPrescription();
                n.setC_id(mycase.getC_id().toString());
                n.setDate(mycase.getC_date().toString());
                n.setP_id(mycase.getP_id());
                uncheckoutPrescriptions.add(n);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return uncheckoutPrescriptions;
        }

        return uncheckoutPrescriptions;
    }

    @Override
    public List<Case> getUncheckoutCase(String p_id)
    {
        return iCaseDao.getUncheckouCaseByPatientId(p_id);
    }

    @Override
    public boolean checkPermissionForPrescrb(String c_id, String d_id)
    {
        try {
            Case mycase = iCaseDao.getCaseById(Integer.parseInt(c_id));
            if (mycase != null && mycase.getC_status() == CaseStatusEnum.UNPRESCRIBED.getStatus()&& mycase.getD_id().equals(d_id))
                return true;
            else
                return false;
        }catch (Exception e)
        {
            return false;
        }
    }
    /**
     *  通过病人id获取未缴费的病历单
     * @param p_id
     * @return
     */

    @Override
    public List<Case> getUnpayedCaseByPatientId(String p_id) {
        return iCaseDao.getUnpayedCaseByPatientId(p_id);
    }
    /**
     * 通过病人id 获取已经缴费的病历单
     * @param p_id
     * @return
     */
    @Override
    public List<Case> getHaveChechoutCaseByPatientId(String p_id) {
        return iCaseDao.getHaveChechoutCaseByPatientId(p_id);
    }
}


