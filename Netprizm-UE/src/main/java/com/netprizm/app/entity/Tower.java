package com.netprizm.app.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Tower {
	 
		public int configNodeId;
	    public String nodeType;
	    public int cclId;
	    public double x;
	    public double y;
	    public int configId;
	    public String name;
	    public int numChild;
	    public int parentId;
	    public ArrayList<ConfigNodeCarrier> configNodeCarriers;
	    
	 @Data
	 public static class ConfigNodeCarrier{
	    public int configNodeCarrierId;
	    public int localCellId;
	    public String name;
	    public int frequency;
	    public int bandWidth;
	    public int mu;
	    public String neFreqBand;
	    public double refSignalPower;
	    public int maxPower;
	    public int height;
	    public int startAngle;
	    public int endAngle;
	    public int azimuth;
	    public int rotation;
	    public int configNodeId;
	    public int midCellRadius;
	    public int farCellRadius;
	    public int globalCellId;
	}
}
