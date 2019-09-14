package com.ManageEmployee.viewmodel;

import com.ManageEmployee.dto.TrainingEmployeeDTO;

public class TrainingEmployeeViewModel {
    private TrainingEmployeeDTO trainingEmployee;

    public TrainingEmployeeViewModel(TrainingEmployeeDTO trainingEmployee) {
        this.trainingEmployee = trainingEmployee;
    }

    public TrainingEmployeeViewModel() {
    }

    public TrainingEmployeeDTO getTrainingEmployee() {
        return trainingEmployee;
    }

    public void setTrainingEmployee(TrainingEmployeeDTO trainingEmployee) {
        this.trainingEmployee = trainingEmployee;
    }
}
