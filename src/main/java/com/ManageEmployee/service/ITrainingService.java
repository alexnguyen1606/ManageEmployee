package com.ManageEmployee.service;

import com.ManageEmployee.dto.TrainingDTO;

import java.util.List;

public interface ITrainingService extends GenericService<TrainingDTO> {

    List<TrainingDTO> findAllByStatus(Integer id);
}
