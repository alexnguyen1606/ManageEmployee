package com.ManageEmployee.convert;

import com.ManageEmployee.dto.EmployeeDTO;
import com.ManageEmployee.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConvert {
    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDTO convertToDTO(EmployeeEntity employeeEntity){
        return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }
    public EmployeeEntity convertToEntity(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeDTO,EmployeeEntity.class);
    }
}
