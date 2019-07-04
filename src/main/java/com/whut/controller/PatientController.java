package com.whut.controller;

import com.whut.bean.Case;
import com.whut.bean.Patient;
import com.whut.service.IAppointmentService;
import com.whut.service.ICaseService;
import com.whut.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/patient")
public class PatientController
{
    @Autowired
    IPatientService iPatientService;
    @Autowired
    IAppointmentService iAppointmentService;
    @Autowired
    ICaseService iCaseService;
    @RequestMapping("/login.do")
    public ModelAndView patientLogin(HttpSession httpSession,Patient patient)
    {
        ModelAndView mv = new ModelAndView();
        if (patient.getP_id() == null || patient.getP_id().equals(""))
        {
            mv.addObject("err","id is empty");
            mv.setViewName("login.do");
        }else if (patient.getP_password() == null || patient.getP_password().equals(""))
        {
            mv.addObject("err","password is empty");
            mv.setViewName("login.do");
        }else if(!iPatientService.patientLogin(patient))
        {
            mv.addObject("err","id or password is wrong");
            mv.setViewName("login.do");
        }else
        {
            httpSession.setAttribute("currentPatient",patient.getP_id());//登录成功记录病人id并跳转到病人主界面
            mv.setViewName("patient_main");
        }
        return mv;
    }
    @RequestMapping("/register.do")
    public ModelAndView register(Patient patient)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");//注册失败留在注册界面
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
            mv.setViewName("redirect:/patient_login");//注册成功跳转到登录页面
        }
        return mv;
    }
    @RequestMapping("/appointment.do")
    public ModelAndView appointment(HttpSession httpSession, String dp_id, String date)
    {

        String p_id = (String)httpSession.getAttribute("currentPatient");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("patientlogin");
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
            mv.addObject("err","appointment failed");
        }else
        {
            mv.setViewName("patient_main");//预约成功
        }
        return mv;
    }
    public ModelAndView getAllPersonalInfo(HttpSession httpSession)
    {
        String p_id = (String)httpSession.getAttribute("currentPatient");
        ModelAndView mv = new ModelAndView();
        if (p_id == null || p_id.equals(""))
        {
            mv.addObject("err","patient is empty");//病人没有登录
            mv.setViewName("patientlogin");
        }
        else
        {
            Patient patient = iPatientService.getPatientById(p_id);
            patient.setP_password("");
            List<Case> allMyCase = iCaseService.getCaseByPatientId(p_id);
            mv.addObject("patientInfo",patient);
            mv.addObject("allCase",allMyCase);
            mv.setViewName("personalCenter");
        }
        return mv;
    }

}