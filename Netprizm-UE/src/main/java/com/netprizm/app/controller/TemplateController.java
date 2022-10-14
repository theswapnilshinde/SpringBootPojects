package com.netprizm.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.netprizm.app.entity.Template;
import com.netprizm.app.io.dto.TemplateDto;
import com.netprizm.app.responcesess.CallResponse;
import com.netprizm.app.service.impl.TemplateServiceImpl;


@CrossOrigin
@RestController
@RequestMapping(value ="/api")
public class TemplateController {

	@Autowired
	private TemplateServiceImpl towerServiceImpl;

	@PostMapping
	
	//@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
	public ResponseEntity<CallResponse> createTemplate(@RequestBody TemplateDto template)
	{
		towerServiceImpl.saveDto(template);
		System.out.println("enterd in controller");
		return new  ResponseEntity<>(new CallResponse("Templat Created Success!",true),HttpStatus.CREATED);

	}


	@GetMapping
	public ResponseEntity<List<Template>> getAllTemplate()
	{


		return ResponseEntity.ok(this.towerServiceImpl.getAllTemplate());
	}

	@PutMapping
	public ResponseEntity<?> updateTemplate(@RequestBody TemplateDto template)
	{
		boolean flag=false;
		flag =towerServiceImpl.update(template,flag);
		if(flag==true)
		{

			return new  ResponseEntity<> (new CallResponse(" Success Template is Updated  ",  true),HttpStatus.OK);
		}
		else {

			return new  ResponseEntity<> (new CallResponse(" Template is Not Updated ",  false),HttpStatus.NOT_FOUND);

		}
	}

	@DeleteMapping
	public ResponseEntity<?> deleteTemplate(@RequestBody TemplateDto template)
	{
		String flag= towerServiceImpl.delete(template);
		if(flag=="success")
		{
			return new  ResponseEntity<> (new CallResponse(" Template Deleted ",  true),HttpStatus.OK);
		}
		else
		{
			return new  ResponseEntity<> (new CallResponse(" Template Not Deleted ",  false),HttpStatus.NOT_FOUND);
		}
	}
	/*
	 * @PostMapping(value = "call") public ResponseEntity<CallResponse>
	 * saveResponce(@RequestBody TemplateDto template) {
	 * towerServiceImpl.saveDto(template);
	 * 
	 * 
	 * return new ResponseEntity<>(new CallResponse("New Template Created ",
	 * true),HttpStatus.CREATED);
	 * 
	 * }
	 */
}
