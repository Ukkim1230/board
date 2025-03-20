package com.web.service;

import java.util.List;

import com.web.dto.UserDTO;
import com.web.repository.UserRepository;

public class UserService {
private UserRepository userRepo = new UserRepository();
	
	public List<UserDTO> selectUsers(UserDTO user){
		return userRepo.selectUsers(user);
	}
	public UserDTO selectUser(int uiNum) {
		return userRepo.selectUser(uiNum);
	}
	public int insertUser(UserDTO user) {
		return userRepo.insertUser(user);
	}
	public int updateUser(UserDTO user) {
		return userRepo.updateUser(user);
	}
	public int deleteUser(int uiNum) {
		return userRepo.deleteUser(uiNum);
	}
}
