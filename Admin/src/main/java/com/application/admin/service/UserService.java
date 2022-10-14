package com.application.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.admin.model.User;
import com.application.admin.model.dto.UserDto;


@Service
public interface UserService {
	
	boolean createUser (User dto);
	UserDto updateUser (UserDto dto,Integer userid);
	List <UserDto> getAllUser();
	void deleteUser(Integer userid);
	User login (UserDto userDto);

}
