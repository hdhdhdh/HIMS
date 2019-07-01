package com.whut.controller;

import com.whut.bean.Patient;
import com.whut.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/patient")
public class PatientController
{
    @Autowired
    IPatientService iPatientService;
    @RequestMapping("/login")
    public ModelAndView patirntLogin(Patient patient)
    {
        ModelAndView mv = new ModelAndView();
        Patient patient1 = iPatientService.getPatienById(patient.getP_id());
        if(patient1 == null || !patient1.getP_password().equals(patient.getP_password()))
        {
            mv.setViewName("login");
        }else
            {
            mv.setViewName("patien_main");
        }
        return mv;
    }

}