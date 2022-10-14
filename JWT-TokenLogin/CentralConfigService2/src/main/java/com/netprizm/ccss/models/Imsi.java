package com.netprizm.ccss.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="imsi")
@Data

public class Imsi {
	@Id
	@JsonIgnore
	private int imsiid;
	@JsonIgnore
	private String coreip;
	// @Convert("booleanToInteger")
	@JsonIgnore
	private boolean isreserved;
	private String environment;
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(nullable = false)
	//@PreUpdate
	//@PrePersist 
	//private Date reservationtime = new Date();
	@JsonIgnore
	private  LocalDateTime  reservationtime = LocalDateTime.now();
	@JsonIgnore
	private String imsi;
	private Integer runid;
	@JsonIgnore
	private Integer count;

}
