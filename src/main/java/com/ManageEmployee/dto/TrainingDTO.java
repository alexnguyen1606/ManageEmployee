package com.ManageEmployee.dto;

import java.util.ArrayList;
import java.util.List;

public class TrainingDTO extends BaseDTO {

    private String code;

    private String name;

    private String description;

    private List<TrainingEmployeeDTO> listTrainingEmployee = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public List<TrainingEmployeeDTO> getListTrainingEmployee() {
        return listTrainingEmployee;
    }

    public void setListTrainingEmployee(List<TrainingEmployeeDTO> listTrainingEmployee) {
        this.listTrainingEmployee = listTrainingEmployee;
    }
}
