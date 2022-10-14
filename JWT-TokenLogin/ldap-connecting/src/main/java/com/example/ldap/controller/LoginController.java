package com.example.ldap.controller;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ldap.LdapConnectingApplication;
import com.example.ldap.LdapConnection;
import com.example.ldap.User;

import com.example.ldap.service.impl.Response;


@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	DirContext connetion;
	
	@Autowired
	LdapConnection ldapConnection;
	
	@Autowired
	LdapConnectingApplication application;
	
	//@GetMapping("/api/employees/{id}")
	@GetMapping("/auth/{uid}")//@RequestBody User user
	public User athenticate(@PathVariable String uid) throws NamingException 
	{
		System.out.println("@@@@@@@@@@@ enterd in Controller");
//		String un=user.getUsername();
//		String password=user.getPassword();
//		newConnection();
		//searchUsers();
		//String uid = user.getUid();
		//User newturnUser= new User();
		
		User newturnUser = application.searchUsers(uid);
		//newturnUser.getUid();
	//	ldapConnection.getLdapConnection();
	//	List list=application.getAllUserss();
		//return list ;
		return newturnUser ;
		
	}
	
	 @RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user) throws NamingException 
	{
		System.out.println("@@@@@@@@@@@ enterd in Controller");
//		
		
		String userPassword = user.userPassword;
		String cn= user.cn;
		User newturnUser = application.searchUsers(cn,userPassword);
	
		String newturnUser1=newturnUser.uid;
		if(newturnUser1 !=null) {
			//return Response.success(newturnUser);
			return Response.success(newturnUser);
		}
		else
			return Response.status(HttpStatus.NOT_FOUND);
		
	}
	 
	 @RequestMapping(value = "/log", method = RequestMethod.POST)
		public ResponseEntity<?> auth(@RequestBody User user) throws Exception 
		{
			System.out.println("@@@@@@@@@@@ enterd in Controller");
//			
			
			String userPassword = user.userPassword;
			String cn= user.cn;
			boolean newturnUser1 = application.authUser(cn, userPassword);
			boolean newturnUser2 = application.userVerify(cn, userPassword);
			//String newturnUser1=true;
			if(newturnUser1 ==true) {
				//return Response.success(newturnUser);
				return Response.success(newturnUser1);
			}
			else
				return Response.status(HttpStatus.NOT_FOUND);
			
		}

	
	
	
	
	}
