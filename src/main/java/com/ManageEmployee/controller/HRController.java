package com.ManageEmployee.controller;

import com.ManageEmployee.dto.DepartmentDTO;
import com.ManageEmployee.dto.EmployeeDTO;
import com.ManageEmployee.service.impl.DepartmentServiceImpl;
import com.ManageEmployee.service.impl.EmployeeServiceImpl;
import com.ManageEmployee.util.CookieUtils;
import com.ManageEmployee.viewmodel.StaffViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hr")
public class HRController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private CookieUtils cookieUtils;
    @GetMapping
    public String index(Model model){
        model.addAttribute("hr","active");
        model.addAttribute("staffs",employeeService.findAll());
        return "HR";
    }
    @GetMapping("/add")
    public String form_insert(Model model){
        model.addAttribute("hr","active");
        model.addAttribute("department",departmentService.findAll());
        model.addAttribute("viewmodel",new StaffViewModel());
        return "Staff-form";
    }
    @PostMapping("/add")
    public RedirectView save(@ModelAttribute("viewmodel") StaffViewModel viewModel, HttpServletRequest request){
        DepartmentDTO department = departmentService.findById(viewModel.getDepartmentId());
        viewModel.getEmployee().setDepartment(department);
        viewModel.getBirthDay();
        String createdBy = cookieUtils.getValueUsernameCookie(request);
        viewModel.getEmployee().setCreatedBy(createdBy);
        employeeService.save(viewModel.getEmployee());
        RedirectView rv = new RedirectView("/hr");
        rv.addStaticAttribute("message","Create success");
        rv.addStaticAttribute("alert","success");
        return rv;
    }
    @GetMapping("/update/{id}")
    public String form_update(@PathVariable("id") Integer id, Model model){
        model.addAttribute("hr","active");
        EmployeeDTO employee = employeeService.findById(id);
        StaffViewModel viewmodel = new StaffViewModel();
        viewmodel.setEmployee(employee);
        viewmodel.setDepartmentId(employee.getDepartment().getId());
        model.addAttribute("department",departmentService.findAll());
        model.addAttribute("viewmodel",viewmodel);
        return "Staff-form-update";
    }
    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("viewmodel") StaffViewModel viewModel,HttpServletRequest request){
        DepartmentDTO department = departmentService.findById(viewModel.getDepartmentId());
        viewModel.getEmployee().setDepartment(department);
        String modifiedBy = cookieUtils.getValueUsernameCookie(request);
        viewModel.getEmployee().setModifiedBy(modifiedBy);
        viewModel.getBirthDay();
        employeeService.update(viewModel.getEmployee());
        RedirectView rv = new RedirectView("/hr");
        rv.addStaticAttribute("message","Update success");
        rv.addStaticAttribute("alert","success");
        return rv;
    }
    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") Integer id){
        RedirectView rv = new RedirectView("/hr");
        rv.addStaticAttribute("message","Delete Success");
        rv.addStaticAttribute("alert","success");
        return rv;
    }

}
