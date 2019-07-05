package com.whut.controller;

import com.whut.bean.Doctor;
import com.whut.service.IDoctorService;
import com.whut.service.imp.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.AttributedString;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/DoctorMange")
public class AdminController {

    @Autowired
    public IDoctorService docService;

    //do是请求说明
    @RequestMapping("/getAllDoctor.do")
    public ModelAndView getAllDoctor() {
        List<Doctor> all = docService.getAllDoctor();
        ModelAndView mv = new ModelAndView();
        mv.addObject("DoctorInfo", all);
        mv.setViewName("DoctorMange");
        return mv;

    }

    @RequestMapping("/deleteDoctor.do")
    public String deleteDoctor(String id) {
        docService.deleteDoctor(id);
        return "redirect:getAllDoctor.do";
    }

    @RequestMapping("/toAddDoctor")
    public String toAddDoctor() {
        return "addDoctor";
    }


    @RequestMapping("/AddDoctor.do")
    public String addDoctorPaper(Doctor doctor) {
        docService.addDoctor(doctor);
        return "redirect:getAllDoctor.do";
    }
    /**
     * 注入对象前的初始化方法
     * SSM框架前后端string转date的lang异常及处理方法
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/toupdateDoctor.do")
    public String toupdateDoctor(Model model, String id) {
        model.addAttribute("DoctorInfo", docService.queryDoctorById(id));
        return "updateDoctor";
    }

    @RequestMapping("/update.do")
    public String updateDoctor(Model model, Doctor doctorInfo) {
        docService.updateDoctor(doctorInfo);
        doctorInfo = docService.queryDoctorById(doctorInfo.getD_id());
        model.addAttribute("doctorInfo", doctorInfo);
        return "redirect:getAllDoctor.do";
    }


}


