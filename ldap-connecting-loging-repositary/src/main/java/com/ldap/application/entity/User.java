package com.ldap.application.entity;

public class User {
	
	private String uid;
	private  String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uid, String password) {
		super();
		this.uid = uid;
		this.password = password;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", password=" + password + "]";
	}
	

}
