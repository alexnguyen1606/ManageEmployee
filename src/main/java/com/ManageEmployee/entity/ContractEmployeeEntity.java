package com.ManageEmployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contract_employee")
public class ContractEmployeeEntity extends BaseEntity{
    @Column(name = "start_date")
    private Date startDate;
    @Column(name ="end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private ContractEntity contract;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

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



    public ContractEntity getContract() {
        return contract;
    }

    public void setContract(ContractEntity contract) {
        this.contract = contract;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}
