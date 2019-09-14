package com.ManageEmployee.dto;



import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;


public class EmployeeDTO extends BaseDTO {

    private String fullName;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDay;

    private int gender;

    private int numberInsurence;

    private String address;

    private String phoneNumber;

    private int type;


    private DepartmentDTO department;


    private List<ContractEmployeeDTO> listContractEmployee = new ArrayList<>();

    private List<TrainingEmployeeDTO> listTrainingEmployee = new ArrayList<>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getNumberInsurence() {
        return numberInsurence;
    }

    public void setNumberInsurence(int numberInsurence) {
        this.numberInsurence = numberInsurence;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public List<ContractEmployeeDTO> getListContractEmployee() {
        return listContractEmployee;
    }

    public void setListContractEmployee(List<ContractEmployeeDTO> listContractEmployee) {
        this.listContractEmployee = listContractEmployee;
    }

    public List<TrainingEmployeeDTO> getListTrainingEmployee() {
        return listTrainingEmployee;
    }

    public void setListTrainingEmployee(List<TrainingEmployeeDTO> listTrainingEmployee) {
        this.listTrainingEmployee = listTrainingEmployee;
    }
}
