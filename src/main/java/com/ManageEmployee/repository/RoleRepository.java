package com.ManageEmployee.repository;

import com.ManageEmployee.dto.RoleDTO;
import com.ManageEmployee.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    public RoleEntity findByCode(String code);
}
