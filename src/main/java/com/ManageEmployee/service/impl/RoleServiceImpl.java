package com.ManageEmployee.service.impl;

import com.ManageEmployee.convert.RoleConvert;
import com.ManageEmployee.dto.RoleDTO;
import com.ManageEmployee.entity.RoleEntity;
import com.ManageEmployee.repository.RoleRepository;
import com.ManageEmployee.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleConvert convert;
    @Override
    public List<RoleDTO> findAll() {
        return roleRepository.findAll().
                stream().map(item -> convert.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Integer id) {
        RoleEntity roleEntity = roleRepository.findById(id).get();
        return convert.convertToDTO(roleEntity);
    }

    @Override
    public void deleteById(Integer id) {
        if (id!=null && findById(id)!=null){
            roleRepository.deleteById(id);
        }
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        if (roleDTO.getId()==null){
            RoleEntity roleEntity = convert.convertToEntity(roleDTO);
            return convert.convertToDTO(roleRepository.save(roleEntity));
        }
        return null;
    }

    @Override
    public RoleDTO update(RoleDTO roleDTO) {
        if (roleDTO.getId()!=null){
            RoleEntity roleEntity = convert.convertToEntity(roleDTO);
            RoleEntity roleEntityInDb = roleRepository.findById(roleDTO.getId()).get();
            roleEntity.setCreatedBy(roleEntityInDb.getCreatedBy());
            roleEntity.setModifiedBy(roleEntityInDb.getModifiedBy());
            return convert.convertToDTO(roleRepository.save(roleEntity));
        }
        return null;
    }

    @Override
    public RoleDTO findByCode(String code) {
        return convert.convertToDTO(roleRepository.findByCode(code));
    }
}
