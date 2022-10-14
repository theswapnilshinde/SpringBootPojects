package com.netprizm.app.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.netprizm.app.io.dto.ConfigNodeCarriersDto;

import lombok.Data;

@Entity
@Table(name ="towerdata")
@Data
public class TowerData {

	private int configNodeId;
	private String nodeType;
	@Id
	private int cclId;
	private int x;
	private int y;
	private int configId;
	private String name;
	private int numChild;
	private int parentId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ConfigNodeCarriers> configNodeCarriers;
	// ": [

	// private List<ConfigNodeCarriers> list ;//": [
	// private LinkedList<ConfigNodeCarriersDto> carriersDtos;
}
