package com.ManageEmployee.service;

import com.ManageEmployee.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService extends GenericService<EmployeeDTO> {
    public List<EmployeeDTO> findByStatus();
    public List<EmployeeDTO> findAllByfullName(String nameEmployee);
    public List<EmployeeDTO> findAllByTypeAndStatus(int type,int status);
    public List<EmployeeDTO> findAllEmployeeExpires();
}
