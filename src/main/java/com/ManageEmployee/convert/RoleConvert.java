package com.ManageEmployee.convert;

import com.ManageEmployee.dto.RoleDTO;
import com.ManageEmployee.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleConvert {
    @Autowired
    private ModelMapper modelMapper;
    public RoleDTO convertToDTO(RoleEntity entity){
        return modelMapper.map(entity,RoleDTO.class);
    }
    public RoleEntity convertToEntity(RoleDTO roleDTO){
        return modelMapper.map(roleDTO,RoleEntity.class);
    }
}
