package com.ManageEmployee.controller;

import com.ManageEmployee.dto.RoleDTO;
import com.ManageEmployee.dto.UserDTO;
import com.ManageEmployee.service.impl.RoleServiceImpl;
import com.ManageEmployee.service.impl.UserServiceImpl;
import com.ManageEmployee.viewmodel.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AutherizationController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl roleService;
    @GetMapping("/manage/autherization")
    public String index(Model model){
        model.addAttribute("users",userService.findAll());
        return "Autherization-Index";
    }
    @GetMapping("/manage/autherization/{id}")
    public String autherization(@PathVariable("id") Integer id,Model model){
        UserDTO userDTO = userService.findById(id);
        UserViewModel viewModel = new UserViewModel();
        Set<RoleDTO> roles = new HashSet<>(roleService.findAll());
        viewModel.setRoles(roles);
        viewModel.setUser(userDTO);
        model.addAttribute("viewmodel",viewModel);
        return "Autherization";
    }
    @PostMapping("/manage/autherization")
    public RedirectView update(@ModelAttribute("viewmodel") UserViewModel viewModel){
        UserDTO userDTO = viewModel.getUser();
        userDTO.getListRole().clear();
        for (Integer id : viewModel.getListIdRole()){
                //userDTO.setListRole(new HashSet<>());
            userDTO.getListRole().add(roleService.findById(id));
        }
        userService.updateAutherization(userDTO);
        return new RedirectView("/manage/autherization");
    }
}
