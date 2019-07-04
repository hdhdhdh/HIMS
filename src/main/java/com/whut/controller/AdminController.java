package com.whut.controller;

import com.whut.bean.Doctor;
import com.whut.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class AdminController
{

/*

    @Autowired
    IDoctorService iDoctorService;
    @RequestMapping("findAllDoctor.do")
    public ModelAndView findAllDoctor(){
        List<Doctor> all = iDoctorService.getAllDoctor();//从DoctorService中获取数据
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("alldoctor",all);
        modelAndView.setViewName("#");//显示在所有医生信息的界面
        return modelAndView;
    }
    @RequestMapping("/toaddDoctor.do")
    public String toaddDoctor(){
        return "#";
    }//返回增加医生界面
    @RequestMapping("/addDoctor.do")
    public String addDoctor(Doctor doctor){
        iDoctorService.addDoctor(doctor);
        return "redirect:/user/findAllDoctor.do";
    }

    */
}
