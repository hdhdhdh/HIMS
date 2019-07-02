package com.whut.controller;

import com.whut.bean.Doctor;
import com.whut.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.event.DocumentEvent;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    IDoctorService iDoctorService;
    @RequestMapping("/toUpdateDoctor.do")
    public String toUpdateDoctor(Model model,String d_id){
        model.addAttribute("doctor",iDoctorService.findDoctorById(d_id));
        return "#";//返回更新医生个人信息界面
    }
    @RequestMapping("/updateDoctor.do")
    public String updateDoctor(Doctor doctor){
        iDoctorService.updateDoctor(doctor);
        return "redirect:/doctor/findDoctor.do";//返回该医生信息界面
    }
    @RequestMapping("findDoctor.do")
    public ModelAndView findDoctor(){
        List<Doctor> one = iDoctorService.findDoctor();//从DoctorService中获取数据
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("onedoctor",one);
        modelAndView.setViewName("#");//显示在医生信息的界面
        return modelAndView;
    }
    @RequestMapping("findDoctor.do")
    public ModelAndView findAllDoctor(){
        List<Doctor> all = iDoctorService.findAllDoctor();//从DoctorService中获取数据
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
}
