package com.ManageEmployee.controller;

import com.ManageEmployee.dto.EmployeeDTO;
import com.ManageEmployee.dto.TrainingEmployeeDTO;
import com.ManageEmployee.service.impl.EmployeeServiceImpl;
import com.ManageEmployee.service.impl.TrainingEmployeeServiceImpl;
import com.ManageEmployee.service.impl.TrainingServiceImpl;
import com.ManageEmployee.util.CookieUtils;
import com.ManageEmployee.viewmodel.TrainingEmployeeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TrainingEmployeeController {
    @Autowired
    private TrainingServiceImpl trainingService;
    @Autowired
    private TrainingEmployeeServiceImpl trainingEmployeeService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private CookieUtils cookieUtils;
    @GetMapping("/trainingemployee")
    public String index(Model model){
        model.addAttribute("training",trainingService.findAll());
        model.addAttribute("train","active");
        return "Training-Employee";
    }
    @GetMapping("/trainingemployee/{id}")
    public String manageTrainingCourse(@PathVariable("id") Integer training_id, Model model){
        model.addAttribute("train","active");
        model.addAttribute("training",trainingService.findById(training_id));
        List<TrainingEmployeeDTO> trainingEmployee = trainingEmployeeService.findByByTraining_id(training_id);
        model.addAttribute("trainingEmployee",trainingEmployee);
        return "Training-info";
    }
    @GetMapping("/search/{id}")
    public String search(Model model,@PathVariable("id") Integer id,
                         @RequestParam(value = "nameEmployee") String nameEmployee){
        model.addAttribute("employee",employeeService.findAllByfullName(nameEmployee));
        return manageTrainingCourse(id,model);
    }

    @GetMapping("/trainingemployee/{trainingId}/{employeeId}")
    public RedirectView add(@PathVariable("trainingId") Integer trainingId,@PathVariable("employeeId") Integer employeeId,HttpServletRequest request){
        TrainingEmployeeDTO trainingEmployee = new TrainingEmployeeDTO();
        trainingEmployee.setEmployee(employeeService.findById(employeeId));
        trainingEmployee.setTraining(trainingService.findById(trainingId));
        trainingEmployee.setCreatedBy(cookieUtils.getValueUsernameCookie(request));
        trainingEmployee.setStatus(1);
        trainingEmployeeService.save(trainingEmployee);
        return new RedirectView("/trainingemployee/"+trainingId);
    }

    @GetMapping("/trainingemployee/update/{trainingId}")
    public String getUpdate(@RequestParam("id") Integer id,@PathVariable("trainingId") Integer trainingId,Model model){
        TrainingEmployeeViewModel viewmodel = new TrainingEmployeeViewModel(trainingEmployeeService.findById(id));
        model.addAttribute("viewmodel",viewmodel);
        return manageTrainingCourse(trainingId,model);
    }

    @PostMapping("/trainingemployee/{trainingId}")
    public RedirectView update(@ModelAttribute("viewmodel") TrainingEmployeeViewModel viewModel
            ,@PathVariable("trainingId") Integer trainingId,HttpServletRequest request){
        TrainingEmployeeDTO trainingEmployee = trainingEmployeeService.findById(viewModel.getTrainingEmployee().getId());
        trainingEmployee.setResult(viewModel.getTrainingEmployee().getResult());
        trainingEmployee.setStatus(viewModel.getTrainingEmployee().getStatus());
        trainingEmployee.setModifiedBy(cookieUtils.getValueUsernameCookie(request));
        trainingEmployeeService.update(trainingEmployee);
        RedirectView rv = new RedirectView("/trainingemployee/"+trainingId);
        rv.addStaticAttribute("message","Update Success");
        rv.addStaticAttribute("alert","success");
        return rv;
    }
}
