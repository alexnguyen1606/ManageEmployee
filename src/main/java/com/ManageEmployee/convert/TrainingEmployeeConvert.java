package com.ManageEmployee.convert;

import com.ManageEmployee.dto.TrainingEmployeeDTO;
import com.ManageEmployee.entity.TrainingEmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainingEmployeeConvert {
    @Autowired
    private ModelMapper modelMapper;
    public TrainingEmployeeDTO convertToDTO(TrainingEmployeeEntity trainingEmployee){
        return modelMapper.map(trainingEmployee,TrainingEmployeeDTO.class);
    }
    public TrainingEmployeeEntity convertToEntity(TrainingEmployeeDTO trainingEmployee){
        return modelMapper.map(trainingEmployee,TrainingEmployeeEntity.class);
    }

}
