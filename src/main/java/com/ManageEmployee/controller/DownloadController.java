package com.ManageEmployee.controller;

import com.ManageEmployee.exportfile.EmployeeExcel;
import com.ManageEmployee.exportfile.EmployeeProbationExcel;
import com.ManageEmployee.systemconstant.ExcelConstant;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class DownloadController {
    @Autowired
    private EmployeeExcel employeeExcel;
    @Autowired
    private EmployeeProbationExcel employeeProbationExcel;
    @GetMapping("/report/download/{report}")
    public void downloadReport(@PathVariable("report") String report,HttpServletResponse response){
        Boolean check = true;
        while (check){
            if (report.equals("employee")){
                File file = new File(ExcelConstant.Path+ExcelConstant.Employees);
                employeeExcel.exportEmployees(file);
                download(response,file);
                check=false;
                break;
            }
            else if (report.equals("expires")){
                File file = new File(ExcelConstant.Path+ExcelConstant.EmployeeExpires);
                download(response,file);
                check = false;
                break;
            }
            else if (report.equals("probation")){
                File file = new File(ExcelConstant.Path+ExcelConstant.EmployeeProbation);
                employeeProbationExcel.exportProbation(file);
                download(response,file);
                check = false;
                break;
            }
            else if (report.equals("trainingemployee")){
                File file = new File(ExcelConstant.Path+ExcelConstant.TrainingEmployee);
                download(response,file);
                check = false;
                break;
            }
        }
    }
    public void download(HttpServletResponse response,File file){
        InputStream inputStream = null;
        try {
            byte[] data = FileUtils.readFileToByteArray(file);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition","attachment;filename="+file.getName());
            response.setContentLength(data.length);
            inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            FileCopyUtils.copy(inputStream,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
