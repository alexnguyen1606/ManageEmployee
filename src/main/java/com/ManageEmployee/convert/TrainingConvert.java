package com.ManageEmployee.convert;

import com.ManageEmployee.dto.TrainingDTO;
import com.ManageEmployee.entity.TrainingEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainingConvert {
    @Autowired
    private ModelMapper modelMapper;

    public TrainingDTO convertToDTO(TrainingEntity trainingEntity){
        return modelMapper.map(trainingEntity,TrainingDTO.class);
    }
    public TrainingEntity convertToEntity(TrainingDTO trainingDTO){
        return modelMapper.map(trainingDTO,TrainingEntity.class);
    }
}
