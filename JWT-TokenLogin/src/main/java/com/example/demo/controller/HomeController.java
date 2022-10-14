package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtRequestFilter;
import com.example.demo.model.JWTRequest;
import com.example.demo.model.JWTResponce;
import com.example.demo.service.UserService;
import com.example.demo.utility.JWTUtility;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	JwtRequestFilter jwtRequestFilter;

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/welcome")
	public String home()
	{
		return "Welcome to Login";

	}

	@PostMapping("/auth")
	JWTResponce jwtResponce(@RequestBody JWTRequest jwtRequest) throws Exception
	{
		final UserDetails userDetails= userDetailsService.loadUserByUsername(jwtRequest.getUsername());

		final String token= jwtUtility.generateToken(userDetails);

		return new JWTResponce(token);

	}



}
