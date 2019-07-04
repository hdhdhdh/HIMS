package com.whut.controller;

import com.whut.bean.Appointment;
import com.whut.bean.Case;
import com.whut.bean.Doctor;
import com.whut.service.IAppointmentService;
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
    @Autowired
    IAppointmentService iAppointmentService;

    @RequestMapping("/toUpdateDoctorWithoutId.do")
    public String toUpdateDoctorWithoutId(Model model,String d_id){
        model.addAttribute("doctor",iDoctorService.getDoctorById(d_id));
        return "#";//返回更新医生个人信息界面
    }
    @RequestMapping("/updateDoctorWithoutId.do")//医生更改自己个人信息
    public String updateDoctorWithoutId(Doctor doctor){
        iDoctorService.updateDoctorWithoutId(doctor);
        return "redirect:/doctor/findAppointment.do";//返回预约信息界面
    }
    @RequestMapping("/toAddCase.do")
    public String toaddCase()
    {
        return "#";
    }//返回增加病例的界面
    @RequestMapping("/addCase.do")//医生增加病例
    public String addCase(Case icase)
    {
        iCaseService.addCase(icase);
        return "redirect:/user/findCase.do";//添加病例后返回所有病例页面
    }
    @RequestMapping("/getCaseByPatientId.do")//医生查找病例
    public ModelAndView getCaseByPatientId(String p_id)
    {
        List<Case> all = iCaseService.getCaseByPatientId(p_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientcases",all);
        modelAndView.setViewName("#");//显示在展示该病例的页面
        return modelAndView;
    }
    @RequestMapping("/getDoctorById.do")//医生查看自己的信息
    public ModelAndView getDoctorById(String d_id){
        Doctor oneDoctor = iDoctorService.getDoctorById(d_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("doctor",oneDoctor);
        modelAndView.setViewName("#");//显示在展示该医生信息的页面
        return modelAndView;
    }
    @RequestMapping("/getAllAppointment.do")//医生查看所有预约信息
    public ModelAndView getAllAppointment(){
        List<Appointment> all = iAppointmentService.getAllAppointment();//从service中获得预约数据
        ModelAndView modelAndView = new ModelAndView();//创建modelAndView对象
        modelAndView.addObject("appointments",all);//给modelAndView对象
        //添加数值，前面的是设置的名字，后面是对应的
        modelAndView.setViewName("#");//显示所有预约信息的界面
        return modelAndView;
    }
    @RequestMapping("doctorLogin.do")
    public String doctorLogin(String d_id,String d_password){
        Doctor doctor = iDoctorService.doctorLogin(d_id,d_password);
        if(doctor != null){
            return  "redirect:/doctor/getAllAppointment.do";//医生登录后得到预约信息界面
        }
        else {return "redirect:../doctorLogin.jsp";}//失败返回登录界面
    }
    @RequestMapping("/updateAppointmentStatus.do")//医生更改预约状态信息
    public String updateAppointmentStatus(Appointment appointment){
        iAppointmentService.updateAppointmentStatus(appointment);
        return "#";//返回预约未处理信息界面
    }
}
