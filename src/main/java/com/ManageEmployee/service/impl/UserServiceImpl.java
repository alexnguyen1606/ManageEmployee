package com.ManageEmployee.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ManageEmployee.convert.UserConvert;
import com.ManageEmployee.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ManageEmployee.dto.UserDTO;
import com.ManageEmployee.repository.UserRepository;
import com.ManageEmployee.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleServiceImpl roleService;
	@Autowired
	private UserConvert userConvert;

	@Override
	public List<UserDTO> findAll() {
		ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepository.findAll();
		return userEntities.stream().map(item -> userConvert.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public UserDTO findById(Integer id) {
		UserEntity userEntity = userRepository.findById(id).get();
		return userEntity != null ? userConvert.convertToDTO(userEntity) : null;
	}

	@Override
	public void deleteById(Integer id) {
		if (id != null && findById(id) != null)
			userRepository.deleteById(id);
	}

	@Override
	public UserDTO save(UserDTO t) {
		if (t.getId() == null && findByUsernameAndEmail(t.getUsername(),t.getEmail()).size()==0) {
			t.getListRole().add(roleService.findByCode("USER"));
			UserEntity userEntity = userConvert.convertToEntity(t);
			userEntity = userRepository.save(userEntity);
			return userConvert.convertToDTO(userEntity);
		}
		return null;
	}

	@Override
	public UserDTO update(UserDTO t) {
		UserEntity userEntity = userConvert.convertToEntity(t);
		if (t.getId() != null) {
			UserEntity userEntityInDB = userRepository.findById(t.getId()).get();
			if (userEntityInDB.getEmail().equals(userEntity.getEmail())) {
				userEntity.setCreatedBy(userEntityInDB.getCreatedBy());
				userEntity.setCreatedDate(userEntityInDB.getCreatedDate());
				userEntity.setListRole(userEntityInDB.getListRole());
				userEntity = userRepository.save(userEntity);
				return userConvert.convertToDTO(userEntity);
			} else {
				if (findByEmail(userEntity.getEmail())==null){
					userEntity.setCreatedBy(userEntityInDB.getCreatedBy());
					userEntity.setCreatedDate(userEntityInDB.getCreatedDate());
					userEntity.setListRole(userEntityInDB.getListRole());
					userEntity = userRepository.save(userEntity);
					return userConvert.convertToDTO(userEntity);
				}else {
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public UserDTO findByUsernameAndPassword(String userName, String passWord) {
		UserEntity user = userRepository.findByUsernameAndPasswordAndStatus(userName,passWord,1);
		if(user!=null) {
			return userConvert.convertToDTO(user);
		}
		else {
			return null;
		}
	}

	@Override
	public List<UserDTO> findByEmail(String email) {
		return userRepository.findByEmail(email)
				.stream().map(item -> userConvert.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public UserDTO findByUsername(String username) {
		return userConvert.convertToDTO(userRepository.findByUsername(username));
	}

	@Override
	public List<UserDTO> findByUsernameAndEmail(String username, String email) {
		return userRepository.findByUsernameAndEmail(username,email).stream()
				.map(item -> userConvert.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateAutherization(UserDTO userDTO) {
		 UserEntity userEntity = userConvert.convertToEntity(userDTO);
		 UserEntity userEntityInDb = userRepository.findById(userEntity.getId()).get();
		 userEntityInDb.setListRole(userEntity.getListRole());
		return userConvert.convertToDTO(userRepository.save(userEntityInDb));

	}

	public Boolean isAuthenticate(String userName,String passWord){
		UserDTO  user = findByUsernameAndPassword(userName,passWord);
		if (user!=null){
			return true;
		}
		else {
			return false;
		}
	}

}
