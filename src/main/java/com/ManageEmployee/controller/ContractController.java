package com.ManageEmployee.controller;

import com.ManageEmployee.dto.ContractDTO;
import com.ManageEmployee.service.impl.ContractServiceImpl;

import com.ManageEmployee.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/category")
public class ContractController {
    @Autowired
    private ContractServiceImpl contractService;
    @Autowired
    private CookieUtils cookieUtils;
    @GetMapping("/contract")
    public String index(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("category", "active");
        return "Category-Contract-Index";
    }

    @GetMapping("/contract/add")
    public String add(Model model) {
        model.addAttribute("viewmodel", new ContractDTO());
        model.addAttribute("category", "active");
        return "Contract-form";
    }

    @PostMapping("/contract/add")
    public RedirectView save(@ModelAttribute("viewmodel") ContractDTO contract, HttpServletRequest request) {
        contract.setCreatedBy(cookieUtils.getValueUsernameCookie(request));
        contractService.save(contract);
        RedirectView rv = new RedirectView("/category/contract");
        rv.addStaticAttribute("message", "Create Success");
        rv.addStaticAttribute("alert", "success");
        return rv;
    }

    @GetMapping("/contract/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("viewmodel", contractService.findById(id));
        model.addAttribute("category", "active");
        return "Contract-form-update";
    }

    @PostMapping("/contract/update")
    public RedirectView updateById(@ModelAttribute("viewmodel") ContractDTO contractDTO,HttpServletRequest request) {
        contractDTO.setModifiedBy(cookieUtils.getValueUsernameCookie(request));
        contractService.update(contractDTO);
        RedirectView rv = new RedirectView("/category/contract");
        rv.addStaticAttribute("message", "Update Success");
        rv.addStaticAttribute("alert", "success");
        return rv;
    }

    @GetMapping("/contract/delete/{id}")
    public RedirectView deleteById(@PathVariable("id") Integer id) {
        RedirectView rv = new RedirectView("/category/contract");
        if (contractService.findById(id) == null) {
            rv.addStaticAttribute("message", "Can't find Contract");
            rv.addStaticAttribute("alert", "warning");
            return rv;
        } else{
            contractService.deleteById(id);
        rv.addStaticAttribute("message", "Delete Success");
        rv.addStaticAttribute("alert", "success");
        return rv;
        }
    }
}
