package com.ManageEmployee.controller;

import com.ManageEmployee.dto.UserDTO;
import com.ManageEmployee.service.impl.UserServiceImpl;
import com.ManageEmployee.util.CookieUtils;
import com.ManageEmployee.viewmodel.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manage/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CookieUtils cookieUtils;
    @GetMapping
    public String index(Model model){
        model.addAttribute("user","active");
        model.addAttribute("users",userService.findAll());
        return "Manage-User";
    }
    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user","active");
        model.addAttribute("viewmodel",new UserViewModel());
        return "Manage-User-Form";
    }
    @PostMapping("/add")
    public RedirectView add(@ModelAttribute("viewmodel") UserViewModel viewModel, HttpServletRequest request){
        UserDTO userDTO = viewModel.getUser();
        userDTO.setCreatedBy(cookieUtils.getValueUsernameCookie(request));
        RedirectView rv = new RedirectView();
        if(userService.save(userDTO)==null){
            rv.addStaticAttribute("message","Username or Email is exits");
            rv.addStaticAttribute("alert","danger");
            rv.setUrl("/manage/user/add");
            return rv;
        }
        else{
            rv.addStaticAttribute("message","Create Success");
            rv.addStaticAttribute("alert","success");
            rv.setUrl("/manage/user");
            return rv;
        }
    }
    @GetMapping("/update/{id}")
    public String updateUser(Model model, @PathVariable("id") Integer id){
        model.addAttribute("user","active");
        UserViewModel viewModel = new UserViewModel();
        viewModel.setUser(userService.findById(id));
        model.addAttribute("viewmodel",viewModel);
        return "Manage-User-Update";
    }
    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("viewmodel") UserViewModel viewModel,HttpServletRequest request){
        UserDTO userDTO = viewModel.getUser();
        userDTO.setModifiedBy(cookieUtils.getValueUsernameCookie(request));
        RedirectView rv = new RedirectView("/manage/user");
        if(userService.update(userDTO)==null){
            rv.addStaticAttribute("message","Update fail!");
            rv.addStaticAttribute("alert","danger");
            return rv;
        }
        else {
            rv.addStaticAttribute("message","Update Success!");
            rv.addStaticAttribute("alert","success");
            return rv;
        }
    }
}
