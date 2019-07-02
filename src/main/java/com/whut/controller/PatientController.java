package com.whut.controller;

import com.whut.bean.Patient;
import com.whut.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/patient")
public class PatientController
{
    @Autowired
    IPatientService iPatientService;
    @RequestMapping("/login.do")
    public ModelAndView patientLogin(Patient patient)
    {
        ModelAndView mv = new ModelAndView();
        if (patient.getP_id() == null || patient.getP_password() == null)
        {
            mv.addObject("err","id or password is empty");
            mv.setViewName("login.do");
        }
        if(iPatientService.patientLogin(patient))
        {
            mv.addObject("err","id or password is wrong");
            mv.setViewName("login.do");
        }else
            {
            mv.setViewName("patient_main");
        }
        return mv;
    }

}