package com.ManageEmployee.convert;

import com.ManageEmployee.dto.UserDTO;
import com.ManageEmployee.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConvert {
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDTO(UserEntity user){
        if (user!=null){
            UserDTO userdto = modelMapper.map(user,UserDTO.class);
            return userdto;
        }
        return null;
    }
    public UserEntity convertToEntity(UserDTO userDTO) {
        if (userDTO != null) {
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            return userEntity;
        }
        return null;
    }
}
