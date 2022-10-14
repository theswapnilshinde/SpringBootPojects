package com.jwtladp.authe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwtladp.authe.entityReponce.JwtRequest;
import com.jwtladp.authe.entityReponce.JwtResponce;
import com.jwtladp.authe.service.UserDetailServices;
import com.jwtladp.authe.utility.JwtUtil;



@RestController
public class JwtController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
    @Autowired
	private UserDetailServices userDetailServices;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value = "/token",method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		System.out.println(jwtRequest);
		try {
			//System.out.println("entred in controller"+ jwtRequest);
			 this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.getStackTrace();
			throw new Exception("Bad credentials");
		}
		UserDetails userDetailsl = this.userDetailServices.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtUtil.generateToken(userDetailsl);
		System.out.println("JWT"+token);
		
		return ResponseEntity.ok(new JwtResponce(token));
	}

}
