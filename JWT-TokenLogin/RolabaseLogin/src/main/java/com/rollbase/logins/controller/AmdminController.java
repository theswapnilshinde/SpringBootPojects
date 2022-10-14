package com.rollbase.logins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/admin")
public class AmdminController {
	
	@GetMapping("/admin")
	public String helloClien()
	{
		return "Hello Admin";
		
	}
	
	@GetMapping("/client")
	public String helloClient()
	{
		return "Hello Client";
		
	}


}
