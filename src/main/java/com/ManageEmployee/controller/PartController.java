package com.ManageEmployee.controller;

import com.ManageEmployee.dto.DepartmentDTO;
import com.ManageEmployee.dto.PartDTO;
import com.ManageEmployee.service.impl.DepartmentServiceImpl;
import com.ManageEmployee.service.impl.PartServiceImpl;
import com.ManageEmployee.util.CookieUtils;
import com.ManageEmployee.viewmodel.PartViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;
import java.util.ArrayList;

@Controller
@RequestMapping("/category")
public class PartController {
    @Autowired
    private PartServiceImpl partService;
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private CookieUtils cookieUtils;
    @GetMapping("/part")
    public String index(Model model){
        model.addAttribute("parts",partService.findAll());
        model.addAttribute("category", "active");
        return "Category-Part-Index";
    }
    @GetMapping("/part/add")
    public String form_insert(Model model){
        model.addAttribute("category","active");
        ArrayList<DepartmentDTO> departments = (ArrayList<DepartmentDTO>) departmentService.findAll();
        model.addAttribute("department",departments);
        model.addAttribute("viewmodel",new PartViewModel());
        return "Part-form";
    }
    @PostMapping("/part/add")
    public RedirectView save(@ModelAttribute("viewmodel") PartViewModel viewmodel, HttpServletRequest request){
        viewmodel.getPart().setCreatedBy(cookieUtils.getValueUsernameCookie(request));
        viewmodel.getPart().setDepartment(departmentService.findById(viewmodel.getDepartmentId()));
        partService.save(viewmodel.getPart());
        RedirectView rv = new RedirectView("/category/part");
        rv.addStaticAttribute("message","Create Success");
        rv.addStaticAttribute("alert","success");
        return rv;
    }
    @GetMapping("/part/update/{id}")
    public String form_update(@PathVariable("id") Integer id, Model model){
        model.addAttribute("category","active");
        PartViewModel viewmodel = new PartViewModel();
        viewmodel.setPart(partService.findById(id));
        viewmodel.setDepartmentId(viewmodel.getDepartmentId());
        model.addAttribute("department",departmentService.findAll());
        model.addAttribute("viewmodel",viewmodel);
        return "Part-form-update";
    }
    @PostMapping("/part/update")
    public RedirectView update(@ModelAttribute("viewmodel") PartViewModel viewmodel,HttpServletRequest request){
        viewmodel.getPart().setModifiedBy(cookieUtils.getValueUsernameCookie(request));
        DepartmentDTO department = departmentService.findById(viewmodel.getDepartmentId());
        viewmodel.getPart().setDepartment(department);
        partService.update(viewmodel.getPart());
        RedirectView rv = new RedirectView("/category/part");
        rv.addStaticAttribute("message","Update Success");
        rv.addStaticAttribute("alert","success");
        return rv;
    }
    @GetMapping("/part/delete/{id}")
    public RedirectView delete(@PathVariable("id") Integer id){
        RedirectView rv = new RedirectView("/category/department");
        if (partService.findById(id) == null) {
            rv.addStaticAttribute("message", "Can't find Part");
            rv.addStaticAttribute("alert", "warning");
            return rv;
        } else{
            partService.deleteById(id);
            rv.addStaticAttribute("message", "Delete Success");
            rv.addStaticAttribute("alert", "success");
            return rv;
        }
    }
}
