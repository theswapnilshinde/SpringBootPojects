package com.netprizm.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "ues")
@Data
public class Ues {
	
	private int startPointX ;
	private int startPointY;
	private int startTime;
	@Id
	private int ueId ;
	private int ueInfoId;

}
