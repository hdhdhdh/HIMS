package com.whut.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.whut.bean.*;
import com.whut.enums.CaseStatusEnum;
import com.whut.service.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            mv.setViewName("../doctor/doctor_home");
        }
        return mv;
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

    /** luodi
     * ajax查询药品的所有信息--带有分页
     * @param page
     * @param size
     * @return */
    @RequestMapping( value = "/ajaxGetAllMedicine.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  getAllMedicine(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "8") int size) {
        List<Medicine> all = iMedicineService.getAllMedicine(page, size);
        PageInfo pageInfo = new PageInfo(all);
        int pageNum = pageInfo.getPageNum();    //获取当前分页页号
        int pages = pageInfo.getPages();        //获取总的页数

        JSONArray array = new JSONArray();
        iMedicineService.getAllMedicine();


        List<Medicine> list = pageInfo.getList(); //得到分页的结果
        for (Medicine medicineTemp:   list ) {

            JSONObject jsonItem = new JSONObject();
            jsonItem.put("m_id",medicineTemp.getM_id());                  //药品的 id
            jsonItem.put("m_name",medicineTemp.getM_name());              //药品的名称
            jsonItem.put("m_num",medicineTemp.getM_num());                  //药品的数量
            jsonItem.put("m_class",medicineTemp.getM_class());            //药品的类型
            jsonItem.put("m_price",medicineTemp.getM_price());                //药品的价格

            array.put(jsonItem);    //将一个医生信息的json对象加入到array中
        }
        JSONObject json = new JSONObject();
        json.put("medicineList",array);   //将医生的信息列表加入到json
        json.put("pageNum",pageNum);    //将当前页号传入到json
        json.put("pages",pages);        //将总的页数传入到json
        return json.toString();
    }

    // 部门管理 luodi
    @RequestMapping(value = "/ajaxAddMedicine.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ajaxAddMedicine(HttpSession session,Medicine medicine) {
        System.out.println(medicine);
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");

       // Doctor doctorMageMedicine=(Doctor) session.getAttribute("currentMedicine");

      JSONObject json=new JSONObject();
      if(iMedicineService.addMedicine(medicine)){
          json.put("message","success");
      }
      else {
          json.put("message","fail");
      }
        return json.toString();
    }




}
