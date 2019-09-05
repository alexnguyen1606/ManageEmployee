package com.ManageEmployee.repository;

import com.ManageEmployee.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
}
