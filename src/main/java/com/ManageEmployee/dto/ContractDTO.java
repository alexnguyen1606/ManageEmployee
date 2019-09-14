package com.ManageEmployee.dto;


import java.util.ArrayList;

import java.util.List;


public class ContractDTO extends BaseDTO{

    private String code;

    private int type;

    private String description;

    private Integer term;

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    private List<ContractEmployeeDTO> listContractEmployee = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ContractEmployeeDTO> getListContractEmployee() {
        return listContractEmployee;
    }

    public void setListContractEmployee(List<ContractEmployeeDTO> listContractEmployee) {
        this.listContractEmployee = listContractEmployee;
    }
}
