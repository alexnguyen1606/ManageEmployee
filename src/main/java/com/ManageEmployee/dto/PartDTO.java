package com.ManageEmployee.dto;

import java.util.ArrayList;
import java.util.List;

public class PartDTO extends BaseDTO {

    private String name;

    private String description;

    private List<DepartmentDTO> listDepartment = new ArrayList<>();

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

    public List<DepartmentDTO> getListDepartment() {
        return listDepartment;
    }

    public void setListDepartment(List<DepartmentDTO> listDepartment) {
        this.listDepartment = listDepartment;
    }
}
