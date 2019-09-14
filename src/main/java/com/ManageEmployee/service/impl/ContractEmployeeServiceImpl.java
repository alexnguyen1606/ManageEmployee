package com.ManageEmployee.service.impl;

import com.ManageEmployee.convert.ContracEmployeeConvert;
import com.ManageEmployee.dto.ContractEmployeeDTO;
import com.ManageEmployee.entity.ContractEmployeeEntity;
import com.ManageEmployee.entity.TrainingEmployeeEntity;
import com.ManageEmployee.repository.ContractEmployeeRepository;
import com.ManageEmployee.service.IContractEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractEmployeeServiceImpl implements IContractEmployeeService {
    @Autowired
    private ContracEmployeeConvert convert;
    @Autowired
    private ContractEmployeeRepository contractEmployeeRepository;
    @Override
    public List<ContractEmployeeDTO> findAll() {
        return contractEmployeeRepository.findAll().stream().map(item -> convert.convertToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public ContractEmployeeDTO findById(Integer id) {
        ContractEmployeeEntity contractEmployee = contractEmployeeRepository.findById(id).get();
        return contractEmployee!=null ? convert.convertToDTO(contractEmployee) : null;
    }

    @Override
    public void deleteById(Integer id) {
        if (id!=null && findById(id)!=null)
        {
            contractEmployeeRepository.deleteById(id);
        }
    }

    @Override
    public ContractEmployeeDTO save(ContractEmployeeDTO contractEmployeeDTO) {
        if (contractEmployeeDTO.getId()==null){
            ContractEmployeeEntity contractEmployee = convert.convertToEntity(contractEmployeeDTO);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(contractEmployee.getStartDate());
            contractEmployee.setStartDate(calendar.getTime());
            calendar.add(Calendar.MONTH,contractEmployee.getContract().getTerm());
            contractEmployee.setEndDate(calendar.getTime());
            contractEmployee = contractEmployeeRepository.save(contractEmployee);
            return convert.convertToDTO(contractEmployee);
        }
        return null;
    }

    @Override
    public ContractEmployeeDTO update(ContractEmployeeDTO contractEmployeeDTO) {
        ContractEmployeeEntity contractEmployee = convert.convertToEntity(contractEmployeeDTO);
        if (contractEmployeeDTO!=null){
            ContractEmployeeEntity contractEmployeeInDb = contractEmployeeRepository.findById(contractEmployeeDTO.getId()).get();
            contractEmployee.setCreatedBy(contractEmployeeInDb.getCreatedBy());
            contractEmployee.setCreatedDate(contractEmployeeInDb.getCreatedDate());
            contractEmployee.setStartDate(contractEmployeeInDb.getStartDate());
            contractEmployee.setEndDate(contractEmployee.getEndDate());
            return convert.convertToDTO(contractEmployeeRepository.save(contractEmployee));
        }
        return null;
    }

    @Override
    public List<ContractEmployeeDTO> findAllByEmployee_Id(Integer employeeId) {
        return contractEmployeeRepository.findAllByEmployee_Id(employeeId)
                .stream().map(item-> convert.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<ContractEmployeeDTO> findAllEmployeeExpires() {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        return contractEmployeeRepository.findAllByExpires(now).stream()
                .map(item -> convert.convertToDTO(item)).collect(Collectors.toList());
    }
}
