package com.netprizm.ccss.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netprizm.ccss.io.dto.ReleaseDto;
import com.netprizm.ccss.io.dto.ReserveDto;
import com.netprizm.ccss.models.Imsi;
import com.netprizm.ccss.repository.ImsiRepositary;
import com.netprizm.ccss.repository.ImsiRepositaryV2;
import com.netprizm.ccss.service.ImsiService;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplServiceImpl2  implements ImsiService{

	private static final Integer Integer = null;
	@Autowired
	private ImsiRepositaryV2 imsiRepositary;

	@Override
	public Imsi saveImsi(Imsi imsi) {
	
		Imsi imsi2 = new Imsi();

		imsi2.setCoreip(imsi.getCoreip());
		imsi2.setIsreserved(true);
		imsi2.setEnvironment(imsi.getEnvironment());
		imsi2.setImsiid(imsi.getImsiid());
		imsi2.setImsi(imsi.getImsi());
		imsi2.setRunid(imsi.getRunid());
	
		findReserved();
		return imsi2;
	}
	
	@Override
	public String reserve(ReserveDto reserveDto  ) {

		try {
			    Imsi imsiid =  new Imsi();
			    
				String envv= reserveDto.getEnvironment();
				int runid= reserveDto.getRunid();
				int count = reserveDto.getCount();
				Boolean flag1 = true;
				
				List<Imsi> listOfImsi  = new ArrayList<>();	
				listOfImsi = imsiRepositary.findByIsreserved(false);
				
				int sizelist= listOfImsi.size();
				
				int listsize = listOfImsi.size();
//				if(count <= listsize)
//				{			

		         	if(sizelist != 0) {
				     for(Imsi imsi2 :listOfImsi )  
				        {   
					      int imsiidset=  imsi2.getImsiid();	
					      imsiRepositary.updateImsi(envv,flag1,runid,count,imsiidset);
					       break;	  
				        }
				     
				   imsiid = imsiRepositary.findByrunid(runid);
				  return  "success";
			}
			else {
				return  "not reseved";
			}
				

		} catch (Exception e) {

			return  "invalid data";
		}

	}



	@Override
	public String release(ReleaseDto releaseDto) {
		String environment= releaseDto.getEnvironment();
		Boolean flag=false;
		int count = 0;
		int runid= releaseDto.getRunid();

		try {

			Imsi imsi2=	imsiRepositary.findByrunid(runid);
		//	Imsi imsi3=	imsiRepositary.findByenvironment(environment);
			if(imsi2 != null ) {
				
				int imssid1=imsi2.getImsiid();
				String envv = null;
				Integer runid1 = null;
				imsiRepositary.updateImsi(envv,flag,runid1,count,imssid1);
				Imsi imsi4 = new Imsi();
				imsi4 = imsiRepositary.findByrunid(runid);
	
				return  "success";	
			}
			else {
			return	"notrelease";
			}

		} catch (Exception e) {

			return  "notrelease";
		}
	}
	

	public Boolean findReserved () {
		List<Imsi> listOfImsi =  imsiRepositary.findByIsreserved(false);
		log.info("listOfImsi::{}",listOfImsi);
		//	imsiRepositary.updateImsi("evv2",true,3,11);
		return null;


	}

	@Override
	public String reserve(Imsi imsi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String release(Imsi imsi) {
		// TODO Auto-generated method stub
		return null;
	}


}
