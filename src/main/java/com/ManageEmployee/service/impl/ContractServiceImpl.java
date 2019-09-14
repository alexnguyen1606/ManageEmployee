package com.ManageEmployee.service.impl;

import com.ManageEmployee.convert.ContractConvert;
import com.ManageEmployee.dto.ContractDTO;
import com.ManageEmployee.entity.ContractEntity;
import com.ManageEmployee.repository.ContractRepository;
import com.ManageEmployee.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractConvert convert;
    @Override
    public List<ContractDTO> findAll() {
        return contractRepository.findAll().stream().map(item-> convert.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public ContractDTO findById(Integer id) {
        ContractEntity contractEntity =contractRepository.findById(id).get();
        return contractEntity!=null ? convert.convertToDTO(contractEntity): null;
    }

    @Override
    public void deleteById(Integer id) {
        if(id!=null&&findById(id)!=null)
            contractRepository.deleteById(id);
    }

    @Override
    public ContractDTO save(ContractDTO contractDTO) {
        ContractEntity contractEntity = contractRepository.save(convert.convertToEntity(contractDTO));
        return convert.convertToDTO(contractEntity);
    }

    @Override
    public ContractDTO update(ContractDTO contractDTO) {
        if(contractDTO.getId()!=null){
            ContractEntity contractEntity = convert.convertToEntity(contractDTO);
            ContractEntity contractEntityInDB = contractRepository.findById(contractDTO.getId()).get();
            contractEntity.setCreatedBy(contractEntityInDB.getCreatedBy());
            contractEntity.setCreatedDate(contractEntityInDB.getCreatedDate());
            return convert.convertToDTO(contractRepository.save(contractEntity));
        }
        return null;
    }
}
