package com.netprizm.ccss.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="template")
@Data
public class Template {
	@Id
	private int templateid;
	private String name;
	private String towerdata;
	private Date createat;
	private Date udatedat;

}
