package com.ManageEmployee.repository;

import com.ManageEmployee.entity.ContractEmployeeEntity;
import com.ManageEmployee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractEmployeeRepository extends JpaRepository<ContractEmployeeEntity,Integer> {
    public List<ContractEmployeeEntity> findAllByEmployee_Id(Integer employeeId);
    @Query("select c from ContractEmployeeEntity c where c.endDate < ?1")
    public List<ContractEmployeeEntity> findAllByExpires(Date now);
}
