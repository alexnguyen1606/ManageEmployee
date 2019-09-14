package com.ManageEmployee.controller;

import com.ManageEmployee.dto.DepartmentDTO;
import com.ManageEmployee.dto.TrainingDTO;
import com.ManageEmployee.service.impl.TrainingServiceImpl;
import com.ManageEmployee.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/category")
public class TrainingCourseController {
    @Autowired
    private TrainingServiceImpl trainingService;
    @Autowired
    private CookieUtils cookieUtils;
    @GetMapping("/training")
    public String index(Model model){
        model.addAttribute("category","active");
        model.addAttribute("training",trainingService.findAll());
        return "Category-Training-Index";
    }
    @GetMapping("/training/add")
    public String form_insert(Model model){
        model.addAttribute("category","active");
        model.addAttribute("viewmodel",new TrainingDTO());
        return "Training-form";
    }
    @PostMapping("/training/add")
    public RedirectView insert(@ModelAttribute("viewmodel") TrainingDTO viewmodel, HttpServletRequest request){
        viewmodel.setCreatedBy(cookieUtils.getValueUsernameCookie(request));
        trainingService.save(viewmodel);
        RedirectView rv = new RedirectView("/category/training");
        rv.addStaticAttribute("message","Create Success");
        rv.addStaticAttribute("alert","success");
        return rv;
    }
    @GetMapping("/training/update/{id}")
    public String form_update(@PathVariable("id") Integer id, Model model){
        model.addAttribute("category","active");
        model.addAttribute("viewmodel",trainingService.findById(id));
        return "Training-form2";
    }
    @PostMapping("/training/update")
    public RedirectView update(@ModelAttribute("viewmodel") TrainingDTO viewmodel,HttpServletRequest request){
        viewmodel.setModifiedBy(cookieUtils.getValueUsernameCookie(request));
        trainingService.update(viewmodel);
        RedirectView rv = new RedirectView("/category/training");
        rv.addStaticAttribute("message","Update Success");
        rv.addStaticAttribute("alert","success");
        return rv;
    }
    @GetMapping("/training/delete/{id}")
    public RedirectView delete(@PathVariable("id") Integer id){
        RedirectView rv = new RedirectView("/category/training");
        if (trainingService.findById(id) == null) {
            rv.addStaticAttribute("message", "Can't find Training Cource");
            rv.addStaticAttribute("alert", "warning");
            return rv;
        } else{
            trainingService.deleteById(id);
            rv.addStaticAttribute("message", "Delete Success");
            rv.addStaticAttribute("alert", "success");
            return rv;
        }
    }
}
