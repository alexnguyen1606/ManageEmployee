package com.ManageEmployee.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity{
    @Column(name="fullname",columnDefinition = "NVARCHAR(255)")
    private String fullName;
    @Column(name = "birthday")
    private Date birthDay;
    @Column(name = "gender")
    private int gender;
    @Column(name = "number_insurence")
    private int numberInsurence;
    @Column(name = "address",columnDefinition = "NVARCHAR(255)")
    private String address;
    @Column(name = "phone_number",columnDefinition = "NVARCHAR(255)")
    private String phoneNumber;
    @Column(name = "type")
    private int type;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee")
    private Set<ContractEmployeeEntity> listContractEmployee = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee")
    private Set<TrainingEmployeeEntity> listTrainingEmployee = new HashSet<>();

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

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public Set<ContractEmployeeEntity> getListContractEmployee() {
        return listContractEmployee;
    }

    public void setListContractEmployee(Set<ContractEmployeeEntity> listContractEmployee) {
        this.listContractEmployee = listContractEmployee;
    }

    public Set<TrainingEmployeeEntity> getListTrainingEmployee() {
        return listTrainingEmployee;
    }

    public void setListTrainingEmployee(Set<TrainingEmployeeEntity> listTrainingEmployee) {
        this.listTrainingEmployee = listTrainingEmployee;
    }
}
