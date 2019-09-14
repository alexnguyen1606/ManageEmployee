package com.ManageEmployee.repository;

import com.ManageEmployee.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{
	UserEntity findByUsernameAndPasswordAndStatus(String username,String password,int status);
	List<UserEntity> findByEmail(String email);
	UserEntity findByUsername(String username);
	List<UserEntity> findByUsernameAndEmail(String username,String email);
}
