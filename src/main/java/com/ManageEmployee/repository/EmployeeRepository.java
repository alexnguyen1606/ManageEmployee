package com.ManageEmployee.repository;

import com.ManageEmployee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    public List<EmployeeEntity> findAllByStatus(int status);

    @Query("select e from EmployeeEntity  e where e.fullName like %?1% ")
    List<EmployeeEntity> search(String name);

    public List<EmployeeEntity> findAllByTypeAndStatus(int type,int status );
}
