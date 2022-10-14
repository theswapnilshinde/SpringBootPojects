package com.application.admin.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.admin.model.User;
import com.application.admin.model.dto.UserDto;
import com.application.admin.repo.UserRepositary;
import com.application.admin.service.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepositary userRepositary;
	
	@Override
	public boolean createUser(User dto) {
		
		boolean flag= false;
//		User user = new User();
//		user.setEmail(dto.getAddaress());
//		user.setAddaress(dto.getAddaress());
//		user.setMobileNo(dto.getMobileNo());
		this.userRepositary.save(dto);
		return true ;
	}

	@Override
	public UserDto updateUser(UserDto dto, Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
