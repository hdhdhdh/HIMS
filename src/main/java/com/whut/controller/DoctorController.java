package com.whut.controller;

import com.whut.bean.*;
import com.whut.service.IAppointmentService;
import com.whut.service.ICaseService;
import com.whut.service.IDoctorService;
import com.whut.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
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
    @Autowired
    IMedicineService iMedicineService;
    @RequestMapping("/updateDoctorInfo.do")//医生更改自己个人信息
    public String updateDoctorInfo(Doctor doctor)
    {
        iDoctorService.updateDoctorWithoutId(doctor);
        return "redirect:/doctor/findAppointment.do";//返回预约信息界面
    }
    @RequestMapping("/addCase.do")//医生增加病例
    public ModelAndView addCase(HttpSession httpSession,Case newCase)
    {

        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor.getD_id() == null || doctor.getD_id().equals(""))
        {
            mv.setViewName("../doctor/doctor_login");
        }
        else if (newCase.getP_id() == null || newCase.getP_id().equals(""))
        {
            mv.addObject("err","patient id is empty");
        }
        else if(iAppointmentService.checkDoctorPermissionForDiagnosis(doctor.getDp_id(),newCase.getP_id()) == true) //检查是否有权限
        {
            newCase.setPr_description(null);
            iCaseService.addCase(newCase);
            mv.setViewName("doctor_home");
        }
        else
        {
            mv.addObject("err","Permission denied");
            mv.setViewName("doctor_home");
        }
        return mv;
    }
    @RequestMapping("/getPatientCase.do")//医生查找病例
    public ModelAndView getPatientCase(HttpSession httpSession,String p_id)
    {
        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor.getD_id() == null || doctor.getD_id().equals(""))
        {
            mv.setViewName("../doctor/doctor_login");
        }
        else if(iAppointmentService.checkDoctorPermissionForDiagnosis(doctor.getDp_id(),p_id) == true) //检查是否有权限
        {
            List<Case> all = iCaseService.getCaseByPatientId(p_id);
            mv.addObject("patientcase",all);
            mv.setViewName("patientcase");
        }
        else
        {
            mv.addObject("err","Permission denied");
            mv.setViewName("doctor_home");
        }
        return mv;
    }
//    @RequestMapping("/getDoctorById.do")//医生查看自己的信息
//    public ModelAndView getDoctorById(String d_id)
//    {
//        Doctor oneDoctor = iDoctorService.getDoctorById(d_id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("doctor",oneDoctor);
//        modelAndView.setViewName("#");//显示在展示该医生信息的页面
//        return modelAndView;
//    }
//    @RequestMapping("/getAllAppointment.do")//医生查看所有预约信息
//    public ModelAndView getAllAppointment()
//    {
//        List<Appointment> all = iAppointmentService.getAllAppointment();//从service中获得预约数据
//        ModelAndView modelAndView = new ModelAndView();//创建modelAndView对象
//        modelAndView.addObject("appointments",all);//给modelAndView对象
//        //添加数值，前面的是设置的名字，后面是对应的
//        modelAndView.setViewName("#");//显示所有预约信息的界面
//        return modelAndView;
//    }
    @RequestMapping("doctorLogin.do")
    public ModelAndView doctorLogin(HttpSession httpSession,Doctor doctor) {
        ModelAndView mv = new ModelAndView();
        if (doctor.getD_id() == null || doctor.getD_id().equals(""))
        {
            mv.addObject("err", "id is empty");//setViewName的时候不要jsp后缀
            mv.setViewName("../doctor/doctor_login");
        } else if (doctor.getD_password() == null || doctor.getD_password().equals(""))
        {
            mv.addObject("err", "password is empty");
            mv.setViewName("../doctor/doctor_login");
        } else if (iDoctorService.doctorLogin(doctor) == false)
        {
            mv.addObject("err", "id or password is wrong");
            mv.setViewName("../doctor/doctor_login");
        } else
        {
            httpSession.setAttribute("currentDoctor", doctor);//登录成功记录医生id并跳转到医生主界面
            mv.setViewName("../doctor/doctor_home");
        }
        return mv;
    }
    @RequestMapping("/updateAppointmentStatus.do")//医生更改预约状态信息
    public ModelAndView updateAppointmentStatus(HttpSession httpSession,Case mycase)
    {

        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor.getD_id() == null || doctor.getD_id().equals(""))
        {
            mv.setViewName("../doctor/doctor_login");
        }
        else if(iAppointmentService.checkDoctorPermissionForDiagnosis(doctor.getDp_id(),mycase.getP_id()) == true) //检查是否有权限
        {
            iAppointmentService.updateAppointmentStatus(mycase.getC_id());
            mv.setViewName("../doctor/doctor_home");
        }
        else
        {
            mv.addObject("err","Permission denied");
            mv.setViewName("doctor_home");
        }
        return mv;
    }
    public ModelAndView getUnprocessedAppointment(HttpSession httpSession,String type)
    {
        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        List<Appointment> selectedAppointment = new ArrayList<Appointment>();
        if (doctor == null)
        {
            mv.setViewName("../doctor/doctor_login"); //未登录
        }
        else
        {
            iAppointmentService.getAUnprocessedAppointmentList(doctor.getDp_id(),type);
        }
        return mv;
    }
    public ModelAndView searchMedicineByName(HttpSession httpSession ,String m_name)
    {
        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");

        if (doctor == null)
        {
            mv.setViewName("../doctor/doctor_login"); //未登录
        }else
        {
            List<Medicine> selectedMedicine = iMedicineService.getMedicineByName(m_name);
            mv.addObject("selectedMedicine",selectedMedicine);
            mv.setViewName("searchMedicine");
        }
        return mv;
    }
    public ModelAndView getProcessedAppointment(HttpSession httpSession)
    {
        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor == null)
        {
            mv.setViewName("../doctor/doctor_login"); //未登录
        }else
        {
            List<Appointment> processedAppointment = iAppointmentService.getProcessedAppointment(doctor.getDp_id());
            mv.addObject("processedAppointments",processedAppointment);
            mv.setViewName("processedAppointments");//显示在已处理预约界面
        }
        return mv;
    }
}
