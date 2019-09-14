package com.ManageEmployee.convert;

import com.ManageEmployee.dto.ContractDTO;
import com.ManageEmployee.entity.ContractEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.ws.Action;

@Component
public class ContractConvert {

    private ModelMapper modelMapper;
    public ContractConvert(){
        modelMapper = new ModelMapper();
    }
    public ContractDTO convertToDTO(ContractEntity contractEntity){
        return modelMapper.map(contractEntity,ContractDTO.class);
    }

    public ContractEntity convertToEntity(ContractDTO contractDTO){
        return modelMapper.map(contractDTO,ContractEntity.class);
    }
}
