package com.ManageEmployee.viewmodel;

import com.ManageEmployee.dto.ContractEmployeeDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractEmployeeViewModel {
    private ContractEmployeeDTO contractEmployee;
    private Integer contractId;
    private Integer employeeId;
    private String startDateString;
    private Date startDate;
    public ContractEmployeeDTO getContractEmployee() {
        return contractEmployee;
    }

    public void setContractEmployee(ContractEmployeeDTO contractEmployee) {
        this.contractEmployee = contractEmployee;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    public Date getStartDate() {
        try {
            startDate = new SimpleDateFormat("dd-MM-yyyy").parse(this.startDateString);
            return startDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
