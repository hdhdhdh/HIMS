package com.whut.controller;

import com.whut.bean.Patient;
import com.whut.service.IAppointmentService;
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
    @Autowired
    IAppointmentService iAppointmentService;
    @RequestMapping("/login.do")
    public ModelAndView patientLogin(Patient patient)
    {
        ModelAndView mv = new ModelAndView();
        if (patient.getP_id() == null || patient.getP_password() == null)
        {
            mv.addObject("err","id or password is empty");
            mv.setViewName("login.do");
        }
        if(!iPatientService.patientLogin(patient))
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
        mv.setViewName("register");
        if (patient.getP_id() == null || patient.getP_id().equals(""))
        {
            mv.addObject("err","id is empty");
        }
        if (patient.getP_name() == null || patient.getP_name().equals(""))
        {
            mv.addObject("err","name is empty");
        }
        if (patient.getP_gender() == null || patient.getP_gender().equals(""))
        {
            mv.addObject("err","gender is empty");
        }
        if (patient.getP_birthday() == null  || patient.getP_birthday().equals(""))
        {
            mv.addObject("err","birthday is empty");
        }
        if (patient.getP_password() == null || patient.getP_password().equals(""))
        {
            mv.addObject("err","password is empty");
        }
        if (iPatientService.addPatient(patient) == false)
        {
            mv.addObject("err","has already registered");
        }else
        {
            mv.setViewName("redirect:/patient_main");
        }
        return mv;
    }
    @RequestMapping("/appointment.do")
    public ModelAndView appointment(String p_id,String dp_id)
    {
        ModelAndView mv = new ModelAndView();
        if (p_id == null || p_id.equals(""))
        {
            mv.addObject("err","patient is empty");
        }
        else if (dp_id == null || dp_id.equals(""))
        {
            mv.addObject("err","department is empty");
        }
        else if(iAppointmentService.addAppointment(p_id,dp_id))
        {
            mv.addObject("err","id or password is wrong");
        }else
        {
            mv.setViewName("patient_main");
        }
        return mv;
    }

}