package com.ManageEmployee.convert;

import com.ManageEmployee.dto.DepartmentDTO;
import com.ManageEmployee.entity.DepartmentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConvert {
    @Autowired
    private ModelMapper modelMapper;

    public DepartmentDTO convertToDTO(DepartmentEntity entity){
        return modelMapper.map(entity,DepartmentDTO.class);
    }
    public DepartmentEntity convertToEntity(DepartmentDTO departmentDTO){
        return modelMapper.map(departmentDTO,DepartmentEntity.class);
    }
}
