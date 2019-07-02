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
    @RequestMapping("/register.do")
    public ModelAndView register(Patient patient)
    {
        ModelAndView mv = new ModelAndView();
        if (patient.getP_id() == null)
        {
            mv.addObject("err","id is empty");
            mv.setViewName("login.do");
        }
        if (patient.getP_name() == null)
        {
            mv.addObject("err","name is empty");
            mv.setViewName("login.do");
        }
        if (patient.getP_gender() == null)
        {
            mv.addObject("err","gender is empty");
            mv.setViewName("login.do");
        }
        if (patient.getP_birthday() == null)
        {
            mv.addObject("err","birthday is empty");
            mv.setViewName("login.do");
        }
        if (patient.getP_password() == null)
        {
            mv.addObject("err","password is empty");
            mv.setViewName("login.do");
        }
        if (iPatientService.addPatient(patient) == false)
        {
            mv.addObject("err","has already registered");
            mv.setViewName("login.do");
        }else
        {
            mv.setViewName("redirect:/patient_main");
        }
        return mv;
    }
    @RequestMapping("/login.do")
    public ModelAndView appointment(String p_id,String dp_id)
    {
        ModelAndView mv = new ModelAndView();
        if (p_id == null)
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