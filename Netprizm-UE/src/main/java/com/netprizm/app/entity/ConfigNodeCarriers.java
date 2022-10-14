package com.netprizm.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Table(name="configNodeCarriers")

public class ConfigNodeCarriers {
	
	private int configNodeCarrierId ;
	@Id
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
 //   @JsonIgnore
   // @OneToMany(cascade = CascadeType.ALL)
	//   @Transient
  // private List<CarrierPropagations> carrierPropagations;
    

	public int getConfigNodeCarrierId() {
		return configNodeCarrierId;
	}
	public void setConfigNodeCarrierId(int configNodeCarrierId) {
		this.configNodeCarrierId = configNodeCarrierId;
	}
	public int getLocalCellId() {
		return localCellId;
	}
	public void setLocalCellId(int localCellId) {
		this.localCellId = localCellId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getBandWidth() {
		return bandWidth;
	}
	public void setBandWidth(int bandWidth) {
		this.bandWidth = bandWidth;
	}
	public int getMu() {
		return mu;
	}
	public void setMu(int mu) {
		this.mu = mu;
	}
	public String getNeFreqBand() {
		return neFreqBand;
	}
	public void setNeFreqBand(String neFreqBand) {
		this.neFreqBand = neFreqBand;
	}
	public float getRefSignalPower() {
		return refSignalPower;
	}
	public void setRefSignalPower(float refSignalPower) {
		this.refSignalPower = refSignalPower;
	}
	public int getMaxPower() {
		return maxPower;
	}
	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getStartAngle() {
		return startAngle;
	}
	public void setStartAngle(int startAngle) {
		this.startAngle = startAngle;
	}
	public int getEndAngle() {
		return endAngle;
	}
	public void setEndAngle(int endAngle) {
		this.endAngle = endAngle;
	}
	public int getAzimuth() {
		return azimuth;
	}
	public void setAzimuth(int azimuth) {
		this.azimuth = azimuth;
	}
	public int getRotation() {
		return rotation;
	}
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	public int getConfigNodeId() {
		return configNodeId;
	}
	public void setConfigNodeId(int configNodeId) {
		this.configNodeId = configNodeId;
	}
	public int getMidCellRadius() {
		return midCellRadius;
	}
	public void setMidCellRadius(int midCellRadius) {
		this.midCellRadius = midCellRadius;
	}
	public int getFarCellRadius() {
		return farCellRadius;
	}
	public void setFarCellRadius(int farCellRadius) {
		this.farCellRadius = farCellRadius;
	}
	public int getGlobalCellId() {
		return globalCellId;
	}
	public void setGlobalCellId(int globalCellId) {
		this.globalCellId = globalCellId;
	}
	
	
	
}
