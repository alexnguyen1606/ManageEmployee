package com.ManageEmployee.service.impl;

import com.ManageEmployee.convert.EmployeeConvert;
import com.ManageEmployee.dto.ContractEmployeeDTO;
import com.ManageEmployee.dto.EmployeeDTO;
import com.ManageEmployee.entity.EmployeeEntity;
import com.ManageEmployee.repository.EmployeeRepository;
import com.ManageEmployee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeConvert convert;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ContractEmployeeServiceImpl contractEmployeeService;
    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream().map(item->convert.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        return employeeEntity!=null?convert.convertToDTO(employeeEntity):null;
    }

    @Override
    public void deleteById(Integer id) {
        if(id!=null&&findById(id)!=null)
            employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeRepository.save(convert.convertToEntity(employeeDTO));
        return convert.convertToDTO(employeeEntity);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        if(employeeDTO.getId()!=null){
            EmployeeEntity employee = convert.convertToEntity(employeeDTO);
            EmployeeEntity employeeInDB = employeeRepository.findById(employeeDTO.getId()).get();
            employee.setCreatedBy(employeeInDB.getCreatedBy());
            employee.setCreatedDate(employeeInDB.getCreatedDate());
            employee = employeeRepository.save(employee);
            return convert.convertToDTO(employee);
        }else
            return null;

    }

    @Override
    public List<EmployeeDTO> findByStatus() {
        return employeeRepository.findAllByStatus(1).stream().map(item-> convert.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findAllByfullName(String nameEmployee) {
        return employeeRepository.search(nameEmployee)
                .stream().map(item -> convert.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findAllByTypeAndStatus(int type, int status) {
        return employeeRepository.findAllByTypeAndStatus(type,status).
                stream().map(item-> convert.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findAllEmployeeExpires() {
        HashMap<Integer,Integer> employeeExpires = new HashMap<Integer, Integer>();
        ArrayList<ContractEmployeeDTO> contractEmployees = (ArrayList<ContractEmployeeDTO>) contractEmployeeService.findAll();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        for(ContractEmployeeDTO contractEmployee : contractEmployees){
            if (contractEmployee.getEndDate().compareTo(now)<0)
            {
                if (employeeExpires.containsKey(contractEmployee.getEmployee().getId())&&employeeExpires.containsValue(1) )
                {
                    employeeExpires.put(contractEmployee.getEmployee().getId(),1);
                }
                else{
                    employeeExpires.put(contractEmployee.getEmployee().getId(),0);
                }

            }else if(contractEmployee.getEndDate().compareTo(now)>0){
                employeeExpires.put(contractEmployee.getEmployee().getId(),1);
            }
        }
        List<EmployeeDTO> employees = new ArrayList<>();
        for (Map.Entry map : employeeExpires.entrySet()){
            if (map.getValue().equals(0))
                employees.add(findById((Integer) map.getKey()));
        }
        return employees;
    }
}
