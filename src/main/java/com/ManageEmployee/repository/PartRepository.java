package com.ManageEmployee.repository;

import com.ManageEmployee.entity.PartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<PartEntity,Integer>{
}
