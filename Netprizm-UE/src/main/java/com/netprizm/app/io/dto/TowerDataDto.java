package com.netprizm.app.io.dto;

import java.util.List;

import javax.persistence.Id;

import lombok.Data;

//import com.netprizm.app.entity.ConfigNodeCarriers;
@Data
public class TowerDataDto {
	
	
	private int configNodeId   ;   //": 32,
	private String nodeType     ; //": "DU",
	@Id
	private int    cclId    ;                 //": 1,
	private int    x  ;//": -537.9916018891913,
	private int  y    ;//": -797.917497405944,
	private int  configId;  //": 10,
    private String  name ;  //": "tower-2",
    private int   numChild  ;  //": 3,
    private int   parentId  ;//": 30,
  	private  List<ConfigNodeCarriersDto> configNodeCarriers  ;//": [

}
