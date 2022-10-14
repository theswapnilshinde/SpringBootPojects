package com.netprizm.app.io.dto;

import java.util.List;

import com.netprizm.app.entity.TowerData;
import com.netprizm.app.entity.Ues;

import lombok.Data;
@Data
public class TemplateDto {
	
	private int	templateId ;
	private String name   ;
	private List<TowerData> towers;
	private List<Ues> ues;
}