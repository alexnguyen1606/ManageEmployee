package com.ManageEmployee.dto;


import java.util.ArrayList;

import java.util.List;


public class DepartmentDTO extends BaseDTO{

    private String name;

    private String description;


    private List<EmployeeDTO> listEmployee = new ArrayList<>();

    private List<PartDTO> listPart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EmployeeDTO> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<EmployeeDTO> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public List<PartDTO> getListPart() {
        return listPart;
    }

    public void setListPart(List<PartDTO> listPart) {
        this.listPart = listPart;
    }
}
