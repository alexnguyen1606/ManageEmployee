package com.ManageEmployee.controller;

import com.ManageEmployee.dto.DepartmentDTO;
import com.ManageEmployee.service.impl.DepartmentServiceImpl;
import com.ManageEmployee.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/category")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private CookieUtils cookieUtils;
    @GetMapping("/department")
    private String index(Model model){
        model.addAttribute("category","active");
        model.addAttribute("departments",departmentService.findAll());
        return "Category-Department-Index";
    }
    @GetMapping("/department/add")
    public String form_insert(Model model){
        model.addAttribute("category","active");
        model.addAttribute("viewmodel",new DepartmentDTO());
        return "Department-form";
    }
    @PostMapping("/department/add")
    private RedirectView insert(@ModelAttribute("viewmodel") DepartmentDTO departmentDTO, HttpServletRequest request){
        String createdBy= cookieUtils.getValueUsernameCookie(request);
        departmentDTO.setCreatedBy(createdBy);
        departmentService.save(departmentDTO);
        RedirectView rv = new RedirectView("/category/department");
        rv.addStaticAttribute("message","Create Success");
        rv.addStaticAttribute("alert","success");
        return rv;
    }
    @GetMapping("/department/update/{id}")
    public String form_update(@PathVariable("id") Integer id,Model model){
        model.addAttribute("category","active");
        model.addAttribute("viewmodel",departmentService.findById(id));
        return "Department-form-update";
    }
    @PostMapping("/department/update")
    public RedirectView update(@ModelAttribute("viewmodel") DepartmentDTO departmentDTO,HttpServletRequest request){
        departmentDTO.setModifiedBy(cookieUtils.getValueUsernameCookie(request));
        departmentService.update(departmentDTO);
        RedirectView rv = new RedirectView("/category/department");
        rv.addStaticAttribute("message","Update Success");
        rv.addStaticAttribute("alert","success");
        return rv;
    }
    @GetMapping("/department/delete/{id}")
    public RedirectView delete(@PathVariable("id") Integer id){
        RedirectView rv = new RedirectView("/category/department");
        if (departmentService.findById(id) == null) {
            rv.addStaticAttribute("message", "Can't find Department");
            rv.addStaticAttribute("alert", "warning");
            return rv;
        } else{
            departmentService.deleteById(id);
            rv.addStaticAttribute("message", "Delete Success");
            rv.addStaticAttribute("alert", "success");
            return rv;
        }
    }
}
