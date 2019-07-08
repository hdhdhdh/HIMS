package com.whut.controller;

import com.whut.bean.*;
import com.whut.enums.CaseStatusEnum;
import com.whut.enums.GenderEnum;
import com.whut.service.ICaseService;
import com.whut.service.IMedicineService;
import com.whut.service.IPatientService;
import com.whut.service.IPrescriptionService;
import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.AssertFalse;
import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pharmacist")
public class PharmacistController {

    @Autowired
    private IMedicineService iMedicineService;
    @Autowired
    private ICaseService iCaseService;
    //do是请求说明
    @Autowired
    private IPrescriptionService iPrescriptionService;
    @Autowired
    IPatientService iPatientService;

    @RequestMapping("/getAllMedicine.do")

    public ModelAndView getAllMedicine()
    {
        List<Medicine> all = iMedicineService.getAllMedicine();
        ModelAndView mv = new ModelAndView();
        mv.addObject("AllMedicine", all);
        mv.setViewName("allUser");
        return mv;
    }
    public ModelAndView addMedicine(Medicine medicine)
    {
        ModelAndView mv = new ModelAndView();
        if (iMedicineService.addMedicine(medicine) == false)
        {
            mv.addObject("err","add medicine failed");
        }
        mv.setViewName("pharmacist_main");
        return mv;
    }
    public ModelAndView deleteMedicine (String m_id)
    {
        ModelAndView mv = new ModelAndView();
        if (iMedicineService.deleteMedicine(m_id) == false)
        {
            mv.addObject("err","delete medicine failed");
        }
        mv.setViewName("pharmacist_main");
        return mv;
    }

    @RequestMapping( value = "/getUncheckoutPrescription.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUncheckoutPrescription(HttpSession httpSession ,String p_id)//获取
    {
        System.out.println(p_id+"ffffffffffffffffffffffffffffffffffffff");
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor == null )
        {
            return   new JSONObject().put("message","please login").toString();
        }else
        {
            List<Case> cases = iCaseService.getUncheckoutCaseByPatientId(p_id);
            JSONArray array = new JSONArray();
            for(Case mycase:cases)
            {
                Patient patient = iPatientService.getPatientById(mycase.getP_id());
                JSONObject jsonObject = new JSONObject();
                List<Prescription> prescriptions = iPrescriptionService.getPrescriptionByCaseId(mycase.getC_id());
                jsonObject.put("p_id",patient.getP_id());
                jsonObject.put("p_name",patient.getP_name());
                jsonObject.put("p_gender", GenderEnum.getGenderEnum(patient.getP_gender()).getValues());
                jsonObject.put("c_id",mycase.getC_id());
                String m_list = "";
                for (Prescription p :prescriptions)
                {
                    m_list = m_list+iMedicineService.getMedicineById(p.getM_id()).getM_name()+":"+p.getM_id()+"|";
                }
                jsonObject.put("m_list",m_list);
                array.put(jsonObject);
            }
            return array.toString();
        }
    }
    @RequestMapping( value = "/checkoutPrescription.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String checkoutPrescription(HttpSession httpSession,Integer c_id)
    {
        System.out.println("checkoutPrescription"+c_id);
        Doctor doctor = (Doctor) httpSession.getAttribute("currentDoctor");
        if (doctor == null )
        {
            return   new JSONObject().put("message","please login").toString();
        }
        else if(iCaseService.checkPermissionForCheckout(c_id) == false) //检查是否有权限
        {
            return   new JSONObject().put("message","Permission denied").toString();
        }
        else if(iMedicineService.checkout(iPrescriptionService.getPrescriptionByCaseId(c_id)) == true && iCaseService.updateCaseSataus(c_id,CaseStatusEnum.CHECKOUT.getStatus()) == true)
        {
            return   new JSONObject().put("message","successed").toString();


        }else
        {
            return   new JSONObject().put("message","checkout failed").toString();
        }
    }


}







