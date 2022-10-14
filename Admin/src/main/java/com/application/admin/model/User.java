package com.application.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Table(name = "usertable")
@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private int UserId;
	private String email;
	private String address;
	private String mobileNo;
	
}
