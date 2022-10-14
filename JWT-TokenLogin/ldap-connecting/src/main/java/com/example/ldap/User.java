package com.example.ldap;

import javax.naming.directory.Attribute;

public class User {

	//public String username;
	public String uid;
	public String cn;
	public String sname;
	public String userPassword;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", cn=" + cn + ", sname=" + sname + "]";
	}
	public User(String uid,String cn, String sname ) {
		super();
		this.uid = uid;
		this.sname = sname;
		this.cn = cn;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
