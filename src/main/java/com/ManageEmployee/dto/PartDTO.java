package com.ManageEmployee.dto;

import java.util.ArrayList;
import java.util.List;

public class PartDTO extends BaseDTO {

    private String name;

    private String description;

    private DepartmentDTO department;


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

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }
}
