package com.whut.controller;

import com.whut.bean.Case;
import com.whut.bean.Doctor;
import com.whut.service.ICaseService;
import com.whut.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    IDoctorService iDoctorService;
    @Autowired
    ICaseService iCaseService;

    @RequestMapping("/toUpdateDoctorWithoutId.do")
    public String toUpdateDoctorWithoutId(Model model,String d_id){
        model.addAttribute("doctor",iDoctorService.getDoctorById(d_id));
        return "#";//返回更新医生个人信息界面
    }
    @RequestMapping("/updateDoctorWithoutId.do")
    public String updateDoctorWithoutId(Doctor doctor){
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
        return "redirect:/user/findCase.do";//添加病例后返回所有病例页面
    }
    @RequestMapping("/getCaseByPatientId.do")
    public ModelAndView getCaseByPatientId(String p_id){
        List<Case> all = iCaseService.getCaseByPatientId(p_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientcases",all);
        modelAndView.setViewName("#");//显示在展示该病例的页面
        return modelAndView;
    }
    @RequestMapping("/getDoctorById.do")
    public ModelAndView getDoctorById(String d_id){
        Doctor oneDoctor = iDoctorService.getDoctorById(d_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("doctor",oneDoctor);
        modelAndView.setViewName("#");//显示在展示该医生信息的页面
        return modelAndView;
    }

}
