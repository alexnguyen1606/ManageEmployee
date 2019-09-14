package com.ManageEmployee.service.impl;

import com.ManageEmployee.convert.DepartmentConvert;
import com.ManageEmployee.dto.DepartmentDTO;
import com.ManageEmployee.entity.DepartmentEntity;
import com.ManageEmployee.repository.DepartmentRepository;
import com.ManageEmployee.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentConvert convert;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<DepartmentDTO> findAll() {
        return departmentRepository.findAll().
                stream().map(item -> convert.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO findById(Integer id) {
        DepartmentEntity entity = departmentRepository.findById(id).get();
        return entity!=null ? convert.convertToDTO(entity) : null;
    }

    @Override
    public void deleteById(Integer id) {
        if (findById(id)!=null)
            departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        DepartmentEntity entity = convert.convertToEntity(departmentDTO);
        entity = departmentRepository.save(entity);
        return convert.convertToDTO(entity);
    }

    @Override
    public DepartmentDTO update(DepartmentDTO departmentDTO) {
        if (departmentDTO.getId()!=null){
            DepartmentEntity entity = convert.convertToEntity(departmentDTO);
            DepartmentEntity entityInDB = departmentRepository.findById(departmentDTO.getId()).get();
            entity.setCreatedBy(entityInDB.getCreatedBy());
            entity.setCreatedDate(entityInDB.getCreatedDate());
            entity = departmentRepository.save(entity);
            return convert.convertToDTO(entity);
        }
        return null;
    }
}
