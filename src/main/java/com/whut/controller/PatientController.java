package com.whut.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpRequest;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.whut.bean.*;
import com.whut.enums.CaseStatusEnum;
import com.whut.service.IAppointmentService;
import com.whut.service.ICaseService;
import com.whut.service.IPatientService;
import com.whut.service.imp.CaseService;
import com.whut.service.imp.DepartmentService;
import com.whut.service.imp.DoctorService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonObject;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    @Autowired
    DepartmentService departmentService;
    @Autowired
    DoctorService doctorService;

//    /**
//     * 用户登录 ---崔佳豪
//     * @param httpSession   session对象
//     * @param patient   patient对象
//     * @return      登录成功进入主页    |   登录失败返回登录页面
//     */
//    @RequestMapping("/login.do")
//    public ModelAndView patientLogin(HttpSession httpSession,Patient patient)
//    {
//        ModelAndView mv = new ModelAndView();
//        if (patient.getP_id() == null || patient.getP_id().equals(""))
//        {
//            mv.addObject("err","id is empty");
//            //setViewName的时候不要jsp后缀
//            mv.setViewName("../patient/patient_login");
//        }else if (patient.getP_password() == null || patient.getP_password().equals(""))
//        {
//            mv.addObject("err","password is empty");
//            mv.setViewName("../patient/patient_login");
//        }else {
//            Patient patient1 = iPatientService.patientCheckLogin(patient.getP_id(),patient.getP_password());
//            if(null == patient1) {
//                mv.addObject("err","id or password is wrong");
//                mv.setViewName("../patient/patient_login");
//            } else {
//                httpSession.setAttribute("currentPatient",patient1);//登录成功记录病人并跳转到病人主界面
//                mv.setViewName("../patient/user_home");
//            }
//        }
//        return mv;
//    }

    /**
     * ajax登录  ---崔佳豪7-6
     * @param session
     * @param patient
     * @return
     */
    @RequestMapping( value = "/patientAjaxLogin.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String patientAjaxLogin(HttpSession session,Patient patient){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        String message;
        Patient patient1 = iPatientService.patientCheckLogin(patient.getP_id(),patient.getP_password());
        if(null == patient1) {
            message = "用户名或者密码错误";
        } else {
            session.setAttribute("currentPatient",patient1); //登录成功记录病人
            message = "success";
        }
        try {
            json = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    /**
     * ajax用户注册  ---崔佳豪7-6
     * @param patient
     * @param birthday 用户出生日期字符串
     * @return
     */
    @RequestMapping( value = "/patientAjaxRegist.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String patientAjaxRegist(Patient patient,String birthday){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        String message;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            patient.setP_birthday(dateFormat.parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (iPatientService.addPatient(patient) == false) { //添加注册信息
            message = "用户已经注册";
        } else {
            message = "success";
        }
        try {
            json = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }




    @RequestMapping("/register.do")
    public ModelAndView register(Patient patient)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/patient/register.jsp");//注册失败留在注册界面
        if (patient.getP_id() == null || patient.getP_id().equals(""))
        {
            mv.addObject("err","id is empty");
        }
        else if (patient.getP_name() == null || patient.getP_name().equals(""))
        {
            mv.addObject("err","name is empty");
        }
        else if (patient.getP_gender() == null || patient.getP_gender().equals(""))
        {
            mv.addObject("err","gender is empty");
        }
        else if (patient.getP_birthday() == null  || patient.getP_birthday().equals(""))
        {
            mv.addObject("err","birthday is empty");
        }
        else if (patient.getP_password() == null || patient.getP_password().equals(""))
        {
            mv.addObject("err","password is empty");
        }
        else if (iPatientService.addPatient(patient) == false)
        {
            mv.addObject("err","has already registered");
        }else
        {
            mv.setViewName("redirect:/patient_login");//注册成功跳转到登录页面
        }
        return mv;
    }

    /**
     * 进入 科室导航 页面 ---崔佳豪
     * @return  获取科室列表后的view
     */
    @RequestMapping("/toDepartmentNav.do")
    public ModelAndView departmentNav(){
        List<Department> departmentList = departmentService.getAllDepartment(); //查询所有科室信息
//        System.out.println("------------------------------------------------------");
//        System.out.println(departmentList);
//        System.out.println("------------------------------------------------------");
        ModelAndView mv = new ModelAndView();
        mv.addObject("departmentList",departmentList);
        mv.setViewName("../patient/department-nav");
        return mv;
    }

    /**
     * 查看科室详情 ---崔佳豪
     * @param dp_id     科室id
     * @return
     */
    @RequestMapping("/departmentItem.do")
    public ModelAndView departmentItem(String dp_id){
        ModelAndView mv = new ModelAndView();
        Department department = departmentService.getDepartmentById(dp_id); //通过id获取科室信息
        mv.addObject("deparment",department);
        mv.setViewName("../patient/department-item");
        return mv;
    }

    /**
     * 进入 医生航行 页面 ---崔佳豪
     * @return
     */
    @RequestMapping("/toDoctorNav.do")
    public ModelAndView doctorNav(){
        ModelAndView mv = new ModelAndView();
        List<Doctor> doctorList = doctorService.getAllDoctor(); //查询所有医生
        List<Department> departmentList = departmentService.getAllDepartment(); //查询所有科室信息
        mv.addObject("departmentList",departmentList);
        mv.addObject("doctorList",doctorList);
        mv.setViewName("../patient/doctor-nav");
        return mv;
    }

    /**
     *  查看医生详情  ---崔佳豪
     * @param d_id  医生id
     * @return
     */
    @RequestMapping("/doctorItem.do")
    public ModelAndView doctorItem(String d_id){
        ModelAndView mv = new ModelAndView();
        Doctor doctor = doctorService.getDoctorById(d_id);  //通过id查找医生
        Department department = departmentService.getDepartmentById(doctor.getDp_id()); //通过医生id 查找医生所属的科室
        mv.addObject("doctor",doctor);
        mv.addObject("department",department);
        mv.setViewName("../patient/doctor-item");
        return mv;
    }


    /**
     * 跳转到appointment界面 ---崔佳豪
     * @param session
     * @return
     */
    @RequestMapping("/toAppointment.do")
    public ModelAndView toAppointment(HttpSession session) {
        Patient patient = (Patient) session.getAttribute("currentPatient");
        ModelAndView mv = new ModelAndView();
        if (patient == null ) {
            mv.setViewName("../patient/patient_login"); //通过id判断，如果没有登录就跳转到登录页面
        }
        else {
            List<Department> departmentList = departmentService.getAllDepartment();
            mv.addObject("departmentList",departmentList);
            mv.setViewName("../patient/appointment");   //登陆过就可以跳转到预约界面
        }
        return mv;
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


    /**
     *     ajax的预约 ---崔佳豪
     * @param appointment
     * @param session
     * @return
     */
    @RequestMapping( value = "/appointment.do",produces = "application/json; charset=utf-8")
    public  @ResponseBody String appointment(Appointment appointment,HttpSession session)
    {
        Patient patient = (Patient) session.getAttribute("currentPatient"); //获取当前session中存的patient
        JSONObject json = new JSONObject();
        if(null==patient) {
            json.put("message","nologin");
        }
        String p_id = patient.getP_id();
        appointment.setP_id(p_id);
        if(iAppointmentService.addAppointment(appointment)){    //预约成功
            json.put("message","success");
        }else { //预约失败
            json.put("message","fail");
        }
//        System.out.println("-------------------------------------------");
//        System.out.println(appointment);
//        System.out.println("--------------------------------------------");

        return json.toString();
    }

    /**
     * 跳转到 个人中心的页面 --崔佳豪
     * @param session
     * @return
     */
    @RequestMapping("/toPersonCenter.do")
    public ModelAndView toPersonCenter(HttpSession session){
        Patient patient = (Patient) session.getAttribute("currentPatient");
        ModelAndView mv = new ModelAndView();
        if (patient == null ) {
            mv.setViewName("../patient/patient_login"); //通过id判断，如果没有登录就跳转到登录页面
        }
        else {
            //个人信息 session中
            //预约信息--通过id查找
            Appointment appointment = null;
            Department department = null;

            appointment = iAppointmentService.getPatientAppointmentById(patient.getP_id());
            if(null != appointment) {
                department = departmentService.getDepartmentById(appointment.getDp_id());
            }

            //代缴费
            List<Case> feesCaseList = iCaseService.getUnpayedCaseByPatientId(patient.getP_id());
            //历史病例
            List<Case> historyCaseList = iCaseService.getHaveChechoutCaseByPatientId(patient.getP_id());
            mv.addObject("appointment",appointment);
            mv.addObject("department",department);
            mv.addObject("feesCaseList",feesCaseList);
            mv.addObject("historyCaseList",historyCaseList);
            mv.setViewName("../patient/person_center");   //登陆过就可以跳转到预约界面
        }
        return mv;
    }

    @RequestMapping( value = "/ajaxToPay.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ajaxToPay(HttpSession session,Integer c_id){

        System.out.println("---------------------------------------");
        System.out.println(c_id);
        System.out.println("---------------------------------------");
        JSONObject json = new JSONObject();
        Patient patient = (Patient) session.getAttribute("currentPatient"); //获取当前session中存的patient
        if(null==patient) {
            json.put("message","nologin");
            return json.toString();
        }
        if(c_id==null) {
            json.put("message","fail");
            return json.toString();
        }
        if(iCaseService.updateCaseSataus(c_id, CaseStatusEnum.UNCHECKOUT.getStatus())) {
            json.put("message","success");
        }else {
            json.put("message","fail");
        }
        return json.toString();
    }



//    @RequestMapping("/appointment.do")
//    public ModelAndView appointment(HttpSession httpSession, String dp_id, String date)
//    {
//        String p_id = (String)httpSession.getAttribute("currentPatient");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("../patient/patient_login"); //如果没有登录过跳转到登录页面
//        if (p_id == null || p_id.equals(""))
//        {
//            mv.addObject("err","patient is empty");
//        }
//        else if (dp_id == null || dp_id.equals(""))
//        {
//            mv.addObject("err","department is empty");
//        }
//        else if(iAppointmentService.addAppointment(p_id,dp_id))
//        {
//            mv.addObject("err","appointment failed");
//        }else
//        {
//            mv.setViewName("patient_main");//预约成功
//        }
//        return mv;
//    }







    @RequestMapping("/getAllPersonalInfo.do")
    public ModelAndView getAllPersonalInfo(HttpSession httpSession)
    {
        String p_id = (String)httpSession.getAttribute(" ");
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
    public ModelAndView payPrescription (HttpSession httpSession)
    {
        String p_id = (String)httpSession.getAttribute("currentPatient");
        ModelAndView mv = new ModelAndView();
        if (p_id == null || p_id.equals(""))
        {
            mv.addObject("err","patient is empty");//病人没有登录
            mv.setViewName("patientlogin");
        }
        return mv;
    }

}