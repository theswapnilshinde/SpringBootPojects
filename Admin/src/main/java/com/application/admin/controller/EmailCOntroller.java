package com.application.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.admin.model.ModelEmail;
import com.application.admin.service.EmailService;

@RestController
public class EmailCOntroller {

	@Autowired
	 EmailService emailService;
//
//	@PostMapping("/email")
//	public String welcome()
//	{
//		return "this is email api";
//	}

	@PostMapping("/sendemail")
	public ResponseEntity<?> send(@RequestBody ModelEmail m )
	{
	Boolean result=	emailService.sendEmail(m.getTo(),m.getSubject(),m.getMessage());

		if(result)
		{
	   	return ResponseEntity.ok(m);
		}
		else {
		  	return ResponseEntity.ok("not send");

		}
	}



}
