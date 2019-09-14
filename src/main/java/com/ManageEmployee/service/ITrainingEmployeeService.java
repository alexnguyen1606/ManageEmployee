package com.ManageEmployee.service;

import com.ManageEmployee.dto.TrainingEmployeeDTO;

import java.util.List;

public interface ITrainingEmployeeService extends GenericService<TrainingEmployeeDTO> {
    List<TrainingEmployeeDTO> findByByTraining_id(Integer id);
}
