package com.ManageEmployee.dto;

import java.util.Date;

public class TrainingEmployeeDTO extends BaseDTO {

    private Date startDate;

    private Date endDate;

    private String result;


    private String description;

    private TrainingDTO training;

    private EmployeeDTO employee;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TrainingDTO getTraining() {
        return training;
    }

    public void setTraining(TrainingDTO training) {
        this.training = training;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
