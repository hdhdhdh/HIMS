package com.whut.controller;

import com.whut.bean.Case;
import com.whut.bean.Doctor;
import com.whut.dao.ICaseDao;
import com.whut.service.ICaseService;
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
    @Autowired
    ICaseService iCaseService;

    @RequestMapping("/toUpdateDoctor.do")
    public String toUpdateDoctor(Model model,String d_id){
        model.addAttribute("doctor",iDoctorService.getDoctorById(d_id));
        return "#";//返回更新医生个人信息界面
    }
    @RequestMapping("/updateDoctor.do")
    public String updateDoctor(Doctor doctor){
        iDoctorService.updateDoctorWithoutId(doctor);
        return "redirect:/doctor/findAppointment.do";//返回预约信息界面
    }
    @RequestMapping("/toAddCase.do")
    public String toaddCase(){
        return "#";
    }//返回增加病例的界面
    @RequestMapping("/addCase.do")
    public String addCase(Case icase){
        iCaseService.addCase(icase);
        return "redirect:/user/findCase.do";//返回所有病例页面
    }

}
