package com.ManageEmployee.convert;

import com.ManageEmployee.dto.PartDTO;
import com.ManageEmployee.entity.PartEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartConvert {
    @Autowired
    private ModelMapper modelMapper;
    public PartDTO convertToDTO(PartEntity partEntity){
        return modelMapper.map(partEntity,PartDTO.class);
    }
    public PartEntity convertToEntity(PartDTO partDTO){
        return modelMapper.map(partDTO,PartEntity.class);
    }
}
