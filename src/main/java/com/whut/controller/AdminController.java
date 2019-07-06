package com.whut.controller;

import com.github.pagehelper.PageInfo;
import com.whut.bean.Department;
import com.whut.bean.Doctor;
import com.whut.service.IDepartmentService;
import com.whut.service.IDoctorService;
import com.whut.service.imp.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.AttributedString;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/DoctorMange")
public class AdminController {

    @Autowired
    public IDoctorService docService;


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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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


    // 分页处理

    //do是请求说明
    @RequestMapping("/getAllDoctor.do")
    public ModelAndView getAllDoctor(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        List<Doctor> all = docService.getAllDoctor(page, size);
        PageInfo pageInfo = new PageInfo(all);
        ModelAndView mv = new ModelAndView();
        mv.addObject("ps", pageInfo);
        mv.setViewName("DoctorMange");
        return mv;

    }


    //
    @RequestMapping("/togetAllDepartment")
    public String togetAllDepartment() {
        return "departmentManage";
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


}


