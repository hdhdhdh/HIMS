package com.whut.controller;

import com.whut.bean.*;
import com.whut.enums.CaseStatusEnum;
import com.whut.service.ICaseService;
import com.whut.service.IMedicineService;
import com.whut.service.IPrescriptionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.AssertFalse;
import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pharmacist")
public class PharmacistController {

    @Autowired
    private IMedicineService iMedicineService;
    @Autowired
    private ICaseService iCaseService;
    //do是请求说明
    @Autowired
    private IPrescriptionService iPrescriptionService;

    @RequestMapping("/getAllMedicine.do")

    public ModelAndView getAllMedicine()
    {
        List<Medicine> all = iMedicineService.getAllMedicine();
        ModelAndView mv = new ModelAndView();
        mv.addObject("AllMedicine", all);
        mv.setViewName("allUser");
        return mv;
    }
    public ModelAndView addMedicine(Medicine medicine)
    {
        ModelAndView mv = new ModelAndView();
        if (iMedicineService.addMedicine(medicine) == false)
        {
            mv.addObject("err","add medicine failed");
        }
        mv.setViewName("pharmacist_main");
        return mv;
    }
    public ModelAndView deleteMedicine (String m_id)
    {
        ModelAndView mv = new ModelAndView();
        if (iMedicineService.deleteMedicine(m_id) == false)
        {
            mv.addObject("err","delete medicine failed");
        }
        mv.setViewName("pharmacist_main");
        return mv;
    }


    public ModelAndView getUncheckoutPrescription(HttpSession httpSession ,String p_id)//获取
    {
        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentPharmacist");
        if (doctor.getD_id() == null)
        {
            mv.setViewName("../doctor/doctor_login");
        }else
        {
            List<UncheckoutPrescription> cases = iCaseService.getUncheckoutPrescription(p_id);
            mv.addObject("cases",cases);
            mv.setViewName("getUncheckoutPrescription");

        }
        return mv;
    }

    public ModelAndView checkoutPrescription(HttpSession httpSession,Integer c_id)
    {

        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentPharmacist");
        if (doctor.getD_id() == null)
        {
            mv.setViewName("../doctor/doctor_login");
        }
        else if(iCaseService.checkPermissionForCheckout(c_id)) //检查是否有权限
        {
            mv.addObject("err","Permission denied");
            mv.setViewName("pharmacist_home");
        }
        else if(iMedicineService.checkout(iPrescriptionService.getPrescriptionByCaseId(c_id)) == false)
        {
            mv.addObject("err","checkout prescription failed");
            mv.setViewName("pharmacist_home");
        }else
        {
            iCaseService.updateCaseSataus(c_id, CaseStatusEnum.CHECKOUT.getStatus());
            mv.setViewName("pharmacist_home");
        }
        return mv;
    }


}







