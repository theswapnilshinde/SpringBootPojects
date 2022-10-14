package com.ldap.Ldaplogin.entity;

import org.springframework.stereotype.Service;

@Service
public class Info {
	
	public String name= "swapnil";
	public String password= "swapnil";
	public String  responce="invalid name and password";
	public String success;

	/*
	 * public Info cheak(Info info) {
	 * 
	 * if(name==info.name && password ==info.password)
	 * 
	 * 
	 * return info.success;
	 * 
	 * }
	 */
	public String getResponce() {
		return responce;
	}
	public void setResponce(String responce) {
		this.responce = responce;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public Info(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
