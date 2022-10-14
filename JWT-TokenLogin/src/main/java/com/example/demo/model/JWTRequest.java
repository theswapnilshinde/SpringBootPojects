package com.example.demo.model;

public class JWTRequest {


	public String username;
	public String password;
	public JWTRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public JWTRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "JWTRequest [username=" + username + ", password=" + password + "]";
	}

}
