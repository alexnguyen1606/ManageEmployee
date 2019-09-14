package com.ManageEmployee.service;

import com.ManageEmployee.dto.ContractEmployeeDTO;

import java.util.List;

public interface IContractEmployeeService extends GenericService<ContractEmployeeDTO> {
    public List<ContractEmployeeDTO> findAllByEmployee_Id(Integer employeeId);
    public List<ContractEmployeeDTO> findAllEmployeeExpires();
}
