package com.application.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.admin.model.ModelEmail;
import com.application.admin.model.User;
import com.application.admin.model.dto.UserDto;
import com.application.admin.service.EmailService;
import com.application.admin.service.EmailServiceUserAdmin;
import com.application.admin.service.UserService;
import com.application.admin.service.Impl.UserImpl;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
   private 	EmailServiceUserAdmin emailServiceUserAdmin;
	
	@Autowired
	private UserImpl  userService;

	@PostMapping("/sendemail")
	public ResponseEntity<?> send(@RequestBody User userDto )
	{
		Boolean result =	this.userService.createUser(userDto);
		
	  //  Boolean result1=	emailServiceUserAdmin.sendEmailUser(userDto.getEmail());

		if(result)
		{
	   	return ResponseEntity.ok(userDto);
		}
		else {
		  	return ResponseEntity.ok("not send");

		}
	}



}
