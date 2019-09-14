package com.ManageEmployee.service.impl;

import com.ManageEmployee.convert.PartConvert;
import com.ManageEmployee.dto.PartDTO;
import com.ManageEmployee.entity.PartEntity;
import com.ManageEmployee.repository.PartRepository;
import com.ManageEmployee.service.IPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartServiceImpl implements IPartService{
    @Autowired
    private PartRepository partRepository;
    @Autowired
    private PartConvert convert;
    @Override
    public List<PartDTO> findAll() {
        return partRepository.findAll().stream().map(item-> convert.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public PartDTO findById(Integer id) {
        PartEntity partEntity = partRepository.findById(id).get();
        return partEntity!=null ? convert.convertToDTO(partEntity) : null;
    }

    @Override
    public void deleteById(Integer id) {
        if(findById(id)!=null)
            partRepository.deleteById(id);
    }

    @Override
    public PartDTO save(PartDTO partDTO) {
        PartEntity partEntity = convert.convertToEntity(partDTO);
        partEntity = partRepository.save(partEntity);
        return convert.convertToDTO(partEntity);
    }

    @Override
    public PartDTO update(PartDTO partDTO) {
        if (partDTO.getId()!=null){
            PartEntity partEntity = convert.convertToEntity(partDTO);
            PartEntity partEntityInDB = partRepository.findById(partDTO.getId()).get();
            partEntity.setCreatedBy(partEntityInDB.getCreatedBy());
            partEntity.setCreatedDate(partEntityInDB.getCreatedDate());
            partEntity=partRepository.save(partEntity);
            return convert.convertToDTO(partEntity);
        }
        return null;
    }
}
