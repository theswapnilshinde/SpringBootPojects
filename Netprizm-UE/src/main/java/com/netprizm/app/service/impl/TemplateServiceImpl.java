package com.netprizm.app.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.google.gson.Gson;
import com.netprizm.app.entity.Template;
import com.netprizm.app.entity.TowerData;
import com.netprizm.app.io.dto.TemplateDto;
import com.netprizm.app.io.dto.TowerDataDto;
//import com.netprizm.app.entity.TowerRequestDto;
import com.netprizm.app.repositary.TemplateRepo;
import com.netprizm.app.responcesess.CallResponse;
import com.netprizm.app.service.TemplateService;
@Service
public class  TemplateServiceImpl implements TemplateService   {

	@Autowired
	private TemplateRepo templateRepo;
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public TemplateDto saveDto(TemplateDto templateDto) {	
		Template template = new Template();		
		template.setTemplateId(templateDto.getTemplateId());
		template.setName(templateDto.getName());
		//template.setTowers(templateDto.getTowers());
		template.setTowers(templateDto.getTowers());
		template.setUes(templateDto.getUes());
		templateRepo.save(template);
		return templateDto;

	}

	public List<Template> getAllTemplate() {
		List<Template>  list=templateRepo.findAll();
		return list;
	}

	public boolean update(TemplateDto templateDto,boolean flag) {

		Template template = new Template();
		Integer templateId=0;
		Template templateId2;
		templateId = templateDto.getTemplateId();
		templateId2 = templateRepo.findAllBytemplateId(templateId);
		if(templateId2 !=null)
		{
			//String flag= null;
			delete(templateDto);
			saveResponce(templateDto);
			flag=true;
			return flag;

		}
		else {
			flag=false;
			return flag;
		}

			
	}

	public String delete(TemplateDto templateDto) {

		Template template = new Template(); 	
		int templateId = templateDto.getTemplateId();
		template= templateRepo.findAllBytemplateId(templateId);
		String result=null;
		if(template !=null)
		{
			templateRepo.delete(template);
			System.out.println("Deleted");
			result = "success";
		}
		else {
			result = "NotDeleted";		
		}
		return result;
	}


	@Override
	public CallResponse saveResponce(TemplateDto templateDto) {
		CallResponse callResponse = null;
		try {
			Template template = new Template();
			template.setTemplateId(templateDto.getTemplateId());
			template.setName(templateDto.getName());
			//template.setTowers(templateDto.getTowers());
			template.setTowers(templateDto.getTowers());
			template.setUes(templateDto.getUes());
			templateRepo.save(template);

			callResponse =new CallResponse("Templat Created Success!",true);
		}catch (Exception e) {
			new CallResponse("Failed To Create New Template!",false);
		}
		return callResponse;

	}
}
