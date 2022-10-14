package com.rollbase.logins.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/role")
public class BaseController {
	
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLL_ADMIN')")
	public String helloAdmin()
	{
		return "Hello Admin";
		
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('ROLL_USER') or hasAuthority('ROLL_ADMIN')")
	public String helloUser()
	{
		return "Hello User";
		
	}
	
	@GetMapping("/client")
	public String helloClient()
	{
		return "Hello Client";
		
	}

}
