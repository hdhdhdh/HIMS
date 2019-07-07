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
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
    @RequestMapping( value = "/addCase.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addCase(HttpSession httpSession, String p_id,  String c_description, String c_fee)
    {
//        System.out.println("addcase"+p_id+c_description+c_fee);
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor.getD_id() == null)
        {
            return  new JSONObject().put("message","please login").toString();
        }
        else if (p_id == null || p_id.equals(""))
        {
            return  new JSONObject().put("message","patient id is empty").toString();
        }
        else if(iAppointmentService.checkDoctorPermissionForDiagnosis(doctor.getDp_id(),p_id) == true && iAppointmentService.updateAppointmentStatus(p_id) == true) //检查是否有权限
        {
//            System.out.println("addCasePermissionChecked");
            Case ncase = new Case();
            ncase.setP_id(p_id);
            ncase.setD_id(doctor.getD_id());
            ncase.setC_description(c_description);
            ncase.setC_fee(new BigDecimal(c_fee));
            ncase.setC_status(1);
            ncase.setC_date(new Date());
//            System.out.println(ncase.toString());
            iCaseService.addCase(ncase);
            return (new JSONObject().put("message","successed")).toString();
        }
        else
        {
            return  (new JSONObject().put("message","Permission denied")).toString();
        }
//        JSONObject json = new JSONObject();
//        json.put("message","hhhh");
//        return  json.toString();

//        return  (new JSONObject().put("message","Permission denied")).toString();
    }


    @RequestMapping( value = "/getPatientCase.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getPatientCase(HttpSession httpSession,String p_id)
    {
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        System.out.println(doctor.toString());
        String ret;
        if (doctor.getD_id() == null)
        {
            return   new JSONObject().put("message","please login").toString();
        }
        else if(iAppointmentService.checkDoctorPermissionForDiagnosis(doctor.getDp_id(),p_id) == true) //检查是否有权限
        {
            List<Case> pcases = iCaseService.getCaseByPatientId(p_id);
            Patient patient = iPatientService.getPatientById(p_id);
            System.out.println(pcases.toString());
            JSONArray array = new JSONArray();
            if(pcases == null)
            {
                return   new JSONObject().put("message","no case").toString();
            }
            for(Case pcase:pcases)
            {
                JSONObject json = new JSONObject();
                json.put("p_name",patient.getP_name());
                json.put("p_gender",GenderEnum.getGenderEnum(patient.getP_gender()).getValues());
                json.put("p_birthday",new SimpleDateFormat("yyyy-MM-dd").format(patient.getP_birthday()));
                json.put("c_date",new SimpleDateFormat("yyyy-MM-dd").format(pcase.getC_date()));
                json.put("d_id",pcase.getD_id());
                json.put("c_description",pcase.getC_description());
                array.put(json);
            }
            System.out.println(array.toString());
            return array.toString();
        }
        else
        {
            return   new JSONObject().put("message","Permission denied").toString();
        }

    }



//    @RequestMapping("/getPatientCase.do")//医生查找病例
//    public ModelAndView getPatientCase(HttpSession httpSession,String p_id)
//    {
//        ModelAndView mv = new ModelAndView();
//        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
//        if (doctor.getD_id() == null)
//        {
//            mv.setViewName("../doctor/doctor_login");
//        }
//        else if(iAppointmentService.checkDoctorPermissionForDiagnosis(doctor.getDp_id(),p_id) == true) //检查是否有权限
//        {
//            List<Case> all = iCaseService.getCaseByPatientId(p_id);
//            Patient patient = iPatientService.getPatientById("p_id");
//            mv.addObject("p_name",patient.getP_name());
//            mv.addObject("p_gender",GenderEnum.getGenderEnum(patient.getP_gender()).getValues());
//            mv.addObject("p_birthday",new SimpleDateFormat("yyyy-MM-dd").format(patient.getP_birthday()));
//            mv.addObject("patientCaseList",all);
//            mv.setViewName("../historyCase");
//        }
//        else
//        {
//            mv.addObject("err","Permission denied");
//            mv.setViewName("../unprocessedAppointmentPage");
//        }
//        return mv;
//    }
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
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor == null)
        {
            return   new JSONObject().put("message","please login").toString();
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
                jsonItem.put("a_date",new SimpleDateFormat("yyyy-MM-dd").format(appointment.getA_date()));
                array.put(jsonItem);
            }
            return array.toString();
        }
    }
    @RequestMapping( value = "/getUnprescribedCase.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUnprescribedCase(HttpSession httpSession)
    {
        System.out.println("getUnprescribedCaseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");;
        if (doctor == null)
        {
            return   new JSONObject().put("message","please login").toString();
        }
        else
        {
            List<Case> unprescribedCase = iCaseService.getUnprescribedCase(doctor.getD_id());
            JSONArray array = new JSONArray();
            if(unprescribedCase == null || unprescribedCase.size() == 0)
            {
                return   new JSONObject().put("message","no case").toString();
            }
            for(Case c:unprescribedCase)
            {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("c_id",c.getC_id());
                jsonObject.put("p_name",iPatientService.getPatientById(c.getP_id()).getP_name());
                jsonObject.put("c_date",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getC_date()));
                array.put(jsonObject);
            }
                return array.toString();
        }

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
