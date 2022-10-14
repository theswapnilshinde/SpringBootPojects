package com.netprizm.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONObject;

import com.netprizm.app.io.dto.TowerDataDto;
import com.netprizm.app.io.dto.UesDto;

import lombok.Data;
@Entity
@Table(name ="templates1")
@Data
public class Template {

    @Id
	private int	templateId ;
	private String name   ;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<TowerData> towers;
//	
//	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ues> ues;
  //	private String towers;
	
}
