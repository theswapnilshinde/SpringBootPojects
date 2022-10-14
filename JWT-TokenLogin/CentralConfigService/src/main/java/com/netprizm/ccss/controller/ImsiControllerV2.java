package com.netprizm.ccss.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netprizm.ccss.models.Imsi;
import com.netprizm.ccss.service.impl.ImplServiceImpl;



@CrossOrigin
@RestController
@RequestMapping("/central-cfg-service-v2")
public class ImsiControllerV2 {

	@Autowired
	private ImplServiceImpl imsiService ;



	@PostMapping("/api/v2/config/imsi/reserve")
	public ResponseEntity<Imsi> reserve2( @RequestBody Imsi imsi)
	{
		String  imsi2= this.imsiService.reserve(imsi);

		if(imsi2 =="success")
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			if(imsi2=="not reseved")
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}


	}

	@PostMapping("/api/v2/config/imsi/release")
	public ResponseEntity<Imsi> release2( @RequestBody Imsi imsi)
	{
		String  imsi2= this.imsiService.release(imsi);

		if(imsi2 =="success")
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			if(imsi2=="notrelease")
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}

	}

	



}

