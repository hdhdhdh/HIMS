package com.whut.controller;

import com.whut.bean.Medicine;
import com.whut.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pharmacist")
public class PharmacistController {

    @Autowired
    public IMedicineService medicineService;

    //do是请求说明
    @RequestMapping("/getAllMedicine.do")
    public ModelAndView getAllMedicine()
    {
        List<Medicine> all = medicineService.getAllMedicine();
        ModelAndView mv = new ModelAndView();
        mv.addObject("AllMedicine", all);
        mv.setViewName("allUser");
        return mv;
    }
}







