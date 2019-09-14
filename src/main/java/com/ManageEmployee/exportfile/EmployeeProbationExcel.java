package com.ManageEmployee.exportfile;

import com.ManageEmployee.dto.EmployeeDTO;
import com.ManageEmployee.service.impl.EmployeeServiceImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Component
public class EmployeeProbationExcel {
    @Autowired
    private EmployeeServiceImpl employeeService;
    public void exportProbation(File file){
        if (file.exists()){
            System.out.println("File is exits");
            exits(file);
        }
        else {
            System.out.println("File not found");
            unexits(file);
        }
    }

    private void unexits(File file) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Employee Probation");
        int numRow = 0;
        Row firstRow = sheet.createRow(numRow++);
        setData(firstRow);
        ArrayList<EmployeeDTO> employees = (ArrayList<EmployeeDTO>) employeeService.findAllByTypeAndStatus(1,1);
        for (EmployeeDTO employee : employees){
            Row row = sheet.createRow(numRow++);
            setDataCell(row,employee);
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void exits(File file) {
        try  {
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int numRow = 0;
            Row firstRow = sheet.createRow(numRow++);
            setData(firstRow);
            ArrayList<EmployeeDTO> employees = (ArrayList<EmployeeDTO>) employeeService.findAllByTypeAndStatus(1,1);
            for(EmployeeDTO employee : employees){
                Row row = sheet.createRow(numRow++);
                setDataCell(row,employee);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setDataCell(Row row, EmployeeDTO employee) {
        Cell cell0 = row.createCell(0);
        cell0.setCellValue(employee.getFullName());
        Cell cell1 = row.createCell(1);
        cell1.setCellValue(employee.getDepartment().getName());
        Cell cell2 = row.createCell(2);
        cell2.setCellValue("Nhân viên thử việc");
        Cell cell3 = row.createCell(3);
        cell3.setCellValue(employee.getNumberInsurence());
        Cell cell4 = row.createCell(4);
        cell4.setCellValue(employee.getAddress());
        Cell cell5 = row.createCell(5);
        if (employee.getGender() == 0) {
            cell5.setCellValue("Female");
        } else {
            cell5.setCellValue("Male");
        }
        Cell cell6 = row.createCell(6);
        SimpleDateFormat fmd = new SimpleDateFormat("dd-MM-yyyy");
        cell6.setCellValue(fmd.format(employee.getBirthDay()).toString());
        Cell cell7 = row.createCell(7);
        cell7.setCellValue(employee.getPhoneNumber());
    }
    private void setData(Row row) {
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("FullName");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("Department");
        Cell cell2 = row.createCell(2);
        cell2.setCellValue("Type");
        Cell cell3 = row.createCell(3);
        cell3.setCellValue("Number Insurence");
        Cell cell4 = row.createCell(4);
        cell4.setCellValue("Address");
        Cell cell5 = row.createCell(5);
        cell5.setCellValue("Gender");
        Cell cell6 = row.createCell(6);
        cell6.setCellValue("Birth Day");
        Cell cell7 = row.createCell(7);
        cell7.setCellValue("Phone Number");
    }
}
