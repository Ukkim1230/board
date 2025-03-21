package com.web.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.common.CommonFactory;
import com.web.dto.UserDTO;

public class UserRepository {
	public List<UserDTO> selectUsers(UserDTO user){
		try(SqlSession session = CommonFactory.getSSF().openSession()){
			return session.selectList("UserMapper.selectUsers", user);
		}
	}
	public UserDTO selectUser(int uiNum){
		try(SqlSession session = CommonFactory.getSSF().openSession()){
			return session.selectOne("UserMapper.selectUser", uiNum);
		}
	}
	public int selectCntById(UserDTO user) {
		try(SqlSession session = CommonFactory.getSSF().openSession(true)){
			return session.selectOne("UserMapper.selectCntById", user);
		}
	}
	public int insertUser(UserDTO user) {
		try(SqlSession session = CommonFactory.getSSF().openSession(true)){
			return session.insert("UserMapper.insertUser", user);
		}
	}
	public int updateUser(UserDTO user) {
		try(SqlSession session = CommonFactory.getSSF().openSession(true)){
			return session.update("UserMapper.updateUser", user);
		}
	}
	public int deleteUser(int uiNum) {
		try(SqlSession session = CommonFactory.getSSF().openSession(true)){
			return session.delete("UserMapper.deleteUser", uiNum);
		}
	}
	public UserDTO selectUserByIdAndPwd(UserDTO user){
		try(SqlSession session = CommonFactory.getSSF().openSession()){
			return session.selectOne("UserMapper.selectUserByIdAndPwd", user);
		}
	}
	public static void main(String[] args) {
		UserRepository userRepo = new UserRepository();
		UserDTO user = new UserDTO();
		user.setUiId("kim1");
		int result = userRepo.selectCntById(user);
		System.out.println(result);
	}
}
