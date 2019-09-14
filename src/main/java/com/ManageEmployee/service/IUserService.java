package com.ManageEmployee.service;

import com.ManageEmployee.dto.UserDTO;
import com.ManageEmployee.entity.UserEntity;

import java.util.List;

public interface IUserService extends GenericService<UserDTO> {
	public UserDTO findByUsernameAndPassword(String userName,String passWord);
	public List<UserDTO> findByEmail(String email);
	public UserDTO findByUsername(String username);
	public List<UserDTO> findByUsernameAndEmail(String username,String email);
	public UserDTO updateAutherization(UserDTO userDTO);
}
