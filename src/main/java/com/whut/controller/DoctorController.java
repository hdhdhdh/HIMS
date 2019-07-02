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
        model.addAttribute("doctor",iDoctorService.getDoctorById(d_id));
        return "#";//返回更新医生个人信息界面
    }
    @RequestMapping("/updateDoctor.do")
    public String updateDoctor(Doctor doctor){
        iDoctorService.updateDoctor(doctor);
        return "redirect:/doctor/findDoctor.do";//返回该医生信息界面
    }


}
