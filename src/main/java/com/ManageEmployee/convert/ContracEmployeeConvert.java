package com.ManageEmployee.convert;

import com.ManageEmployee.dto.ContractEmployeeDTO;
import com.ManageEmployee.entity.ContractEmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContracEmployeeConvert {
    @Autowired
    private ModelMapper modelMapper;
    public ContractEmployeeDTO convertToDTO(ContractEmployeeEntity contractEmployee){
        return modelMapper.map(contractEmployee,ContractEmployeeDTO.class);
    }
    public ContractEmployeeEntity convertToEntity(ContractEmployeeDTO contractEmployee){
        return modelMapper.map(contractEmployee,ContractEmployeeEntity.class);
    }
}
