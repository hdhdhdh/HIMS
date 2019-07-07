package com.whut.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whut.bean.*;
import com.whut.enums.CaseStatusEnum;
import com.whut.enums.GenderEnum;
import com.whut.service.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    IPrescriptionService iPrescriptionService;
    @Autowired
    IPatientService iPatientService;

    /**
     *  ajax登录      实现不同职责跳转不同，医生跳转，药剂师跳转  --崔佳豪
     * @param session
     * @param d_id
     * @param d_password
     * @return
     */
    @RequestMapping( value = "/doctorAjaxLogin.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String doctorAjaxLogin(HttpSession session,String d_id,String d_password){
        Doctor doctor = iDoctorService.doctorCheckLogin(d_id,d_password);   //查询到doctor
        JSONObject json= new JSONObject();
        if(doctor==null) {
            json.put("message", "用户名或者密码错误");
        } else {
            session.setAttribute("currentDoctor",doctor); //登录成功记录病人
            json.put("message", "success");
            if(doctor.getT_id().equals("01")) {
                json.put("type","doctor");
            }else if(doctor.getT_id().equals("11")) {
                json.put("type","pharmacist");
            }

        }
//        System.out.println("----------------------------------------");
//        System.out.println(json);
//        System.out.println("-----------------------------------------------");
        return json.toString();
    }


//    @RequestMapping("doctorLogin.do")
//    public ModelAndView doctorLogin(HttpSession httpSession,Doctor doctor) {
//        ModelAndView mv = new ModelAndView();
//        if (doctor.getD_id() == null)
//        {
//            mv.addObject("err", "id is empty");//setViewName的时候不要jsp后缀
//            mv.setViewName("../doctor/doctor_login");
//        } else if (doctor.getD_password() == null || doctor.getD_password().equals(""))
//        {
//            mv.addObject("err", "password is empty");
//            mv.setViewName("../doctor/doctor_login");
//        } else if (iDoctorService.doctorLogin(doctor) == false)
//        {
//            mv.addObject("err", "id or password is wrong");
//            mv.setViewName("../doctor/doctor_login");
//        } else
//        {
//            httpSession.setAttribute("currentDoctor", doctor);//登录成功记录医生id并跳转到医生主界面
//            mv.setViewName("../doctor/doctor_home");
//        }
//        return mv;
//    }


//    /**
//     *  普通职工的登录跳转
//     * @param id            提交的id
//     * @param password      提交的password
//     * @return
//     */
//    @RequestMapping("/doctorLogin.do")
//    public ModelAndView doctorLogin(HttpSession session,String id,String password){
//        ModelAndView mv = new ModelAndView();
//        Doctor doctor = iDoctorService.doctorCheckLogin(id,password);
//        if(doctor==null) {
//            mv.addObject("err","用户名或者密码错误");
//            mv.setViewName("../workerLogin");
//        }else {
//            session.setAttribute("currentDoctor",doctor);
//            mv.setViewName("../worker_index");
//        }
//        return mv;
//    }


    @RequestMapping("/updateDoctorInfo.do")//医生更改自己个人信息
    public String updateDoctorInfo(Doctor doctor)
    {
        iDoctorService.updateDoctorWithoutId(doctor);
        return "redirect:/doctor/findAppointment.do";//返回预约信息界面
    }
    @RequestMapping("/addCase.do")//医生增加病例
    public ModelAndView addCase(HttpSession httpSession,Case newCase,Integer a_id)
    {

        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor.getD_id() == null)
        {
            mv.setViewName("../doctor/doctor_login");
        }
        else if (newCase.getP_id() == null || newCase.getP_id().equals(""))
        {
            mv.addObject("err","patient id is empty");
        }
        else if(iAppointmentService.checkDoctorPermissionForDiagnosis(doctor.getDp_id(),newCase.getP_id()) == true) //检查是否有权限
        {
            iAppointmentService.updateAppointmentStatus(a_id);
            newCase.setPr_description(null);
            newCase.setC_status(CaseStatusEnum.UNPRESCRIBED.getStatus());
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
        if (doctor.getD_id() == null)
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
//
//    public ModelAndView prescribeCase(HttpSession httpSession,Case mycase,String prescription)
//    {
//
//        ModelAndView mv = new ModelAndView();
//        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
//        if (doctor.getD_id() == null)
//        {
//            mv.setViewName("../doctor/doctor_login");
//        }
//        else if(iCaseService.checkDoctorPermissionForPrescribe(doctor.getD_id(),mycase.getC_id()) == false) //检查是否有权限
//        {
//
//            mv.addObject("err","Permission denied");
//            mv.setViewName("../doctor/doctor_home");
//        }
//        else if(iCaseService.addPrescriptionToCase(mycase.getC_id(),prescription) == false)
//        {
//            mv.setViewName("../doctor/doctor_home");
//            mv.addObject("err","add prescription failed");
//        }
//        return mv;
//    }

    /**
     * sfh
     * @param httpSession
     * @param type
     * @return
     */
    @RequestMapping( value = "/getUnprocessedAppointment.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUnprocessedAppointment(HttpSession httpSession,String type)
    {
        System.out.println("shit");
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor == null)
        {
            return "";
        }
        else
        {
            JSONArray array = new JSONArray();
            List<Appointment> selectedAppointment = iAppointmentService.getAUnprocessedAppointmentList(doctor.getDp_id(),type);
            for(Appointment appointment:selectedAppointment)
            {
                JSONObject jsonItem = new JSONObject();
                Patient patient = iPatientService.getPatientById(appointment.getP_id());

                jsonItem.put("p_name",patient.getP_name());
                jsonItem.put("p_gender", GenderEnum.getGenderEnum(patient.getP_gender()).getValues());
                jsonItem.put("p_age",new Date().getYear() - patient.getP_birthday().getYear());
                jsonItem.put("p_id",patient.getP_id());
                jsonItem.put("a_date",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(appointment.getA_date()));
                array.put(jsonItem);
            }
            System.out.println(array.toString());
            return array.toString();
        }
    }
    public ModelAndView getUnprescribedCase(HttpSession httpSession)
    {
        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");;
        if (doctor == null)
        {
            mv.setViewName("../doctor/doctor_login"); //未登录
        }
        else
        {
            List<Case> unprescribedCase = iCaseService.getUnprescribedCase(doctor.getD_id());
            mv.addObject("unprescribedCase",unprescribedCase);
            mv.setViewName("getUnprescribedCase");
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
    public ModelAndView addMedicineToPrescription(HttpSession httpSession,Integer c_id,String m_id)
    {
        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor.getD_id() == null)
        {
            mv.setViewName("../doctor/doctor_login");
        }
        else if(iCaseService.checkDoctorPermissionForPrescribe(doctor.getD_id(),c_id) == false) //检查是否有权限
        {

            mv.addObject("err","Permission denied");
            mv.setViewName("../doctor/doctor_home");
        }
        else if(iPrescriptionService.addMedicineToPrescription(c_id,iMedicineService.getMedicineById(m_id)) == false)
        {
            mv.addObject("err","add medicine to prescription failed");
            mv.setViewName("editPrescription");
        }else
        {
            mv.setViewName("editPrescription");
        }
        return mv;
    }
    public ModelAndView deleteMedicineFromPrescription(HttpSession httpSession,Prescription prescription)
    {
        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor.getD_id() == null)
        {
            mv.setViewName("../doctor/doctor_login");
        }
        else if(iCaseService.checkDoctorPermissionForPrescribe(doctor.getD_id(),prescription.getC_id()) == false) //检查是否有权限
        {

            mv.addObject("err","Permission denied");
            mv.setViewName("../doctor/doctor_home");
        }
        else if(iPrescriptionService.deletePrescription(prescription) == false)
        {
            mv.addObject("err","delete medicine from prescription failed");
            mv.setViewName("editPrescription");
        }else
        {
            mv.setViewName("editPrescription");
        }
        return mv;
    }
    public ModelAndView confirmPrescription(HttpSession httpSession,Integer c_id)
    {
        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor.getD_id() == null)
        {
            mv.setViewName("../doctor/doctor_login");
        }
        else if(iCaseService.checkDoctorPermissionForPrescribe(doctor.getD_id(),c_id) == false) //检查是否有权限
        {
            mv.addObject("err","Permission denied");
            mv.setViewName("../doctor/doctor_home");
        }
        else if(iCaseService.updateCaseSataus(c_id,CaseStatusEnum.UNPADE.getStatus()) == false)
        {
            mv.addObject("err","confirm prescription failed");
            mv.setViewName("editPrescription");
        }else
        {
            mv.setViewName("editPrescription");
        }
        return mv;
    }

}
