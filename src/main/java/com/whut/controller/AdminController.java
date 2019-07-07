package com.whut.controller;

import com.github.pagehelper.PageInfo;
import com.whut.bean.Administrators;
import com.whut.bean.Department;
import com.whut.bean.Doctor;
import com.whut.enums.GenderEnum;
import com.whut.service.IAdministratorsSrevices;
import com.whut.service.IDepartmentService;
import com.whut.service.IDoctorService;
import com.whut.service.imp.AdministratorsService;
import com.whut.service.imp.DepartmentService;
import com.whut.service.imp.DoctorService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonObject;
import javax.servlet.http.HttpSession;
import java.text.AttributedString;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Administrator")
public class AdminController {

    @Autowired
    public IDoctorService docService;
    @Autowired
    AdministratorsService administratorsSrevices;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    private IDepartmentService iDepartmentService;



/*

    //do是请求说明
    @RequestMapping("/getAllDoctor.do")
    public ModelAndView getAllDoctor() {
        List<Doctor> all = docService.getAllDoctor();
        ModelAndView mv = new ModelAndView();
        mv.addObject("DoctorInfo", all);
        mv.setViewName("DoctorMange");
        return mv;
    }
    */

    /**
     *  管理员登录   ---崔佳豪
     * @param session
     * @param ad_id             登录id
     * @param ad_password       登录password
     * @return
     */
    @RequestMapping( value = "/administratorAjaxLogin.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String administratorAjaxLogin(HttpSession session,String ad_id,String ad_password){
        Administrators administrator = administratorsSrevices.administratorsCheckLogin(ad_id,ad_password);
        JSONObject json = new JSONObject();
        if(null == administrator) {
            json.put("message","fail");
        }else {
            session.setAttribute("currentAdministrator",administrator);     //登录成功，保存administrator到session
            json.put("message","success");
        }
        return json.toString();
    }

    /**
     * ajax查询医生所有信息--带有分页   ---崔佳豪
     * @param page
     * @param size
     * @return
     */
    @RequestMapping( value = "/ajaxGetAllDoctor.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  getAllDoctor(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        List<Doctor> all = docService.getAllDoctor(page, size);
        PageInfo pageInfo = new PageInfo(all);
        int pageNum = pageInfo.getPageNum();    //获取当前分页页号
        int pages = pageInfo.getPages();        //获取总的页数

        JSONArray array = new JSONArray();
        departmentService.getAllDepartment();


        List<Doctor> list = pageInfo.getList(); //得到分页的结果
        for (Doctor doctortemp:   list ) {
            JSONObject jsonItem = new JSONObject();
            jsonItem.put("d_id",doctortemp.getD_id());                  //doctor的 id
            jsonItem.put("d_name",doctortemp.getD_name());              //doctor的姓名
            if(1==doctortemp.getD_gender()){                            //doctor的性别
                jsonItem.put("d_gender", "男");
            } else if(2==doctortemp.getD_gender()){
                jsonItem.put("d_gender", "女");
            }else {
                jsonItem.put("d_gender", doctortemp.getD_gender());
            }
            /*日期需要转成字符串*/
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(doctortemp.getD_birthday());
            jsonItem.put("d_birthday",dateString);                      //doctor的生日

            jsonItem.put("t_id",doctortemp.getT_id());                  //doctor的类型id
            jsonItem.put("d_title",doctortemp.getD_title());            //doctor的职称
            jsonItem.put("dp_id",doctortemp.getDp_id());                //doctor的科室id

            array.put(jsonItem);    //将一个医生信息的json对象加入到array中
        }
        JSONObject json = new JSONObject();
        json.put("doctorList",array);   //将医生的信息列表加入到json
        json.put("pageNum",pageNum);    //将当前页号传入到json
        json.put("pages",pages);        //将总的页数传入到json
        return json.toString();
    }

    /**
     * 添加医生 页面获取所有科室   ---崔佳豪
     * @return
     */
    @RequestMapping( value = "/ajaxGetAllDepartmentToSelect.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  getAllDepartmentToSelect() {
        List<Department> departmentList = departmentService.getAllDepartment();     //获取所有的科室信息
        JSONArray array = new JSONArray();
        for (Department departmentTemp :  departmentList ) {
            JSONObject jsonItem = new JSONObject();
            jsonItem.put("dp_id",departmentTemp.getDp_id());                  //department 的 id
            jsonItem.put("dp_name",departmentTemp.getDp_name());              //department 的名字
            array.put(jsonItem);    //将一个科室信息的json对象加入到array中
        }
        return array.toString();
    }

    /**
     *  添加医生 提交的 ajax --崔佳豪
     * @return
     */
    @RequestMapping( value = "/ajaxAddDoctor.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  ajaxAddDoctor(HttpSession session, Doctor doctor) {

//
//        System.out.println("-----------------------------------");
//        System.out.println(doctor);
//        System.out.println("--------------------------------------------------------");
        Administrators administrator = (Administrators) session.getAttribute("currentAdministrator");
        if(administrator==null) {   //没有登录返回空字符串
            return "";
        }
        if(doctor.getDp_id().equals("0901")) {  //分配到药房的为 药剂师
            doctor.setT_id("11");       //药剂师 11
        }else {
            doctor.setT_id("01");       //普通医生 01
        }
        JSONObject json = new JSONObject();
        if(docService.addDoctor(doctor)) {
            json.put("message","success");
        }else {
            json.put("message","fail");
        }
        return json.toString();
    }



    // 删除医生
    @RequestMapping("/deleteDoctor.do")
    public String deleteDoctor(String id) {
        docService.deleteDoctor(id);
        return "redirect:getAllDoctor.do";
    }

    // 添加医生
    @RequestMapping("/toAddDoctor")
    public String toAddDoctor() {
        return "addDoctor";
    }

    // 返回添加医生的页面
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    // 更新医生信息
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


    // 部门管理 luodi
    @RequestMapping(value = "/ajaxGetAllDepartment.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAllDepartment(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        List<Department> all = iDepartmentService.getAllDepartment(page, size);
        PageInfo pageInfo = new PageInfo(all);
        int pageNum = pageInfo.getPageNum();    //获取当前分页页号
        int pages = pageInfo.getPages();        //获取总的页数


        JSONArray array = new JSONArray();
        List<Department> list = pageInfo.getList(); //得到分页的结果
        for (Department departmentTemp : list) {
            JSONObject jsonItem = new JSONObject();
            jsonItem.put("dp_id", departmentTemp.getDp_id());                  //department的 id
            jsonItem.put("dp_name", departmentTemp.getDp_name());              //department的名称
            jsonItem.put("dp_description", departmentTemp.getDp_description());                  //department的简介

            array.put(jsonItem);    //将一个医生信息的json对象加入到array中
        }
        JSONObject json = new JSONObject();
        json.put("departmentList", array);   //将医生的信息列表加入到json
        json.put("pageNum", pageNum);    //将当前页号传入到json
        json.put("pages", pages);        //将总的页数传入到json

        System.out.println("-----------------------------------------");
        System.out.println(json.toString());
        System.out.println("------------------------------------------");
        return json.toString();
    }



    /*
    @RequestMapping("/togetAllDepartment")
    public String togetAllDepartment() {
        return "departmentManage";
    }

    @RequestMapping("/getAllDepartment.do")
    public ModelAndView AllDepartment() {
        List<Department> all = iDepartmentService.getAllDepartment();
        ModelAndView mv = new ModelAndView();
        mv.addObject("DepartmentInfo", all);
        mv.setViewName("departmentManage");
        return mv;
    }


    @RequestMapping("/addDepartment.do")//增加科室
    public ModelAndView addDepartment(HttpSession httpSession, Department department) {

        ModelAndView mv = new ModelAndView();
        department = (Department) httpSession.getAttribute("currentDepartment ");
        if (department.getDp_id() == null || department.getDp_id().equals("")) {
            mv.setViewName("#");//回到管理员登录界面
        } else {
            iDepartmentService.addDepartment(department);
            mv.setViewName("#");//回到管理员登录界面
        }
        return mv;
    }

    @RequestMapping("/getAllDepartment.do")//查找科室
    public ModelAndView getAllDepartment(HttpSession httpSession, String dp_id) {
        ModelAndView mv = new ModelAndView();
        Department department = (Department) httpSession.getAttribute("currentDepartment ");
        if (department.getDp_id() == null || department.getDp_id().equals("")) {
            mv.setViewName("#");//回到管理员登录界面
        } else {
            List<Department> all = iDepartmentService.getAllDepartment();
            mv.setViewName("#");//回到管理员登录界面
        }
        return mv;
    }

    @RequestMapping("/updateDepartment.do")//更改科室信息
    public ModelAndView updateDepartment(HttpSession httpSession, Department department) {
        ModelAndView mv = new ModelAndView();
        department = (Department) httpSession.getAttribute("currentDepartment ");
        if (department.getDp_id() == null || department.getDp_id().equals("")) {
            mv.setViewName("#");//回到管理员登录界面
        } else {
            iDepartmentService.updateDepartment(department);
            mv.setViewName("#");//返回科室信息界面
        }
        return mv;
    }
    */


}


