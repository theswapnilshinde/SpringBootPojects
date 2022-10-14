package com.netprizm.app.io.dto;

import lombok.Data;

@Data
public class ConfigNodeCarriersDto {

	private int configNodeCarrierId ;
	private int  localCellId  ;
	private String  name  ;
	private int  frequency ;
	private int bandWidth  ;
	private int mu  ;
	private String neFreqBand ;
    private float refSignalPower  ;
    private int maxPower;    //": 150,
    private int  height;   //": 30,
    private int startAngle ; //": 88,
    private int endAngle;   //": 120,
    private int  azimuth;   //": 120,
    private int  rotation;  //": 30,
    private int configNodeId;   //": 32,
    private int midCellRadius;   //": 100,
    private int  farCellRadius;    //": 150,
    private int  globalCellId ; //": 327745,
    
}
