package com.ManageEmployee.viewmodel;

import com.ManageEmployee.dto.EmployeeDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StaffViewModel {
    private EmployeeDTO employee;
    private Integer departmentId;
    private String birthDayString;
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public String getBirthDayString() {
        return birthDayString;
    }

    public void setBirthDayString(String birthDayString) {
        this.birthDayString = birthDayString;
    }
    public void getBirthDay(){
        try {
            employee.setBirthDay(new SimpleDateFormat("dd-MM-yyyy").parse(this.getBirthDayString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
