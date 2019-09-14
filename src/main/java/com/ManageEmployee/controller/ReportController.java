package com.ManageEmployee.controller;

import com.ManageEmployee.service.impl.ContractEmployeeServiceImpl;
import com.ManageEmployee.service.impl.EmployeeServiceImpl;
import com.ManageEmployee.service.impl.TrainingEmployeeServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private ContractEmployeeServiceImpl contractEmployeeService;
    @Autowired
    private TrainingEmployeeServiceImpl trainingEmployeeService;
    @GetMapping("/employee")
    public String employees(Model model){
        model.addAttribute("employees",employeeService.findAllByTypeAndStatus(2,1));
        model.addAttribute("report","active");
        return "Report-Employee";
    }
    @GetMapping("/probation")
    public String employeeProbation(Model model){
        model.addAttribute("report","active");
        model.addAttribute("employees",employeeService.findAllByTypeAndStatus(1,1));
        return "Report-Probation";
    }
    @GetMapping("/expiresemployee")
    public String contractExpiresStaff(Model model){
        model.addAttribute("report","active");
        model.addAttribute("employees",employeeService.findAllEmployeeExpires());
        return "Report-Expires-Employee";
    }
    @GetMapping("/trainingemployee")
    public String trainingEmployee(Model model){
        model.addAttribute("report","active");
        model.addAttribute("trainingEmployee",trainingEmployeeService.findAll());
        return "Report-Training-Employee";
    }

}
