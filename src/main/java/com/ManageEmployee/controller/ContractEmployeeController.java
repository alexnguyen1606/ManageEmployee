package com.ManageEmployee.controller;

import com.ManageEmployee.dto.ContractDTO;
import com.ManageEmployee.dto.ContractEmployeeDTO;
import com.ManageEmployee.dto.EmployeeDTO;
import com.ManageEmployee.service.impl.ContractEmployeeServiceImpl;

import com.ManageEmployee.service.impl.ContractServiceImpl;
import com.ManageEmployee.service.impl.EmployeeServiceImpl;
import com.ManageEmployee.util.CookieUtils;
import com.ManageEmployee.viewmodel.ContractEmployeeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
public class ContractEmployeeController {
    @Autowired
    private ContractEmployeeServiceImpl contractEmployeeService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private ContractServiceImpl contractService;
    @Autowired
    private CookieUtils cookieUtils;
    @GetMapping("/contractemployee/{id}")
    public String contract_personal(@PathVariable("id") Integer id, Model model){

        model.addAttribute("employee",employeeService.findById(id));
        model.addAttribute("contractEmployee",contractEmployeeService.findAllByEmployee_Id(id));
        model.addAttribute("contract",contractService.findAll());
        ContractEmployeeViewModel viewModel =new ContractEmployeeViewModel();
        viewModel.setEmployeeId(id);
        model.addAttribute("viewmodel",viewModel);
        return "Contract-Employee";
    }
    @PostMapping("/contractemployee")
    public RedirectView addContractToEmployee(@ModelAttribute("viewmodel")ContractEmployeeViewModel viewModel, HttpServletRequest request){
        ContractEmployeeDTO contractEmployee = new ContractEmployeeDTO();
        contractEmployee.setStartDate(viewModel.getStartDate());
        contractEmployee.setCreatedBy(cookieUtils.getValueUsernameCookie(request));
        ContractDTO contract = contractService.findById(viewModel.getContractId());
        EmployeeDTO employee = employeeService.findById(viewModel.getEmployeeId());
        contractEmployee.setContract(contract);
        contractEmployee.setEmployee(employee);
        contractEmployeeService.save(contractEmployee);
        RedirectView rv = new RedirectView("/hr");
        return rv;
    }

}
