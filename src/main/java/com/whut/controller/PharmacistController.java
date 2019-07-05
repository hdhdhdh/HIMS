package com.whut.controller;

import com.whut.bean.Medicine;
import com.whut.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.AssertFalse;
import javax.xml.ws.soap.Addressing;
import java.util.List;

@Controller
@RequestMapping("/pharmacist")
public class PharmacistController {

    @Autowired
    public IMedicineService iMedicineService;

    //do是请求说明
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


    public ModelAndView checkoutPrescription(String p_id)//添加药物到处方
    {
        return null;
    }



}







