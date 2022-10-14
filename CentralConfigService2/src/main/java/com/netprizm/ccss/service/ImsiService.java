package com.netprizm.ccss.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.netprizm.ccss.io.dto.ReleaseDto;
import com.netprizm.ccss.io.dto.ReserveDto;
import com.netprizm.ccss.models.Imsi;

@Service
public interface ImsiService {

	Imsi saveImsi(Imsi imsi);
	 String reserve(ReserveDto reserveDto );
	 String release(ReleaseDto releaseDto );
	 
	// for v1
	 String reserve(Imsi imsi);
	 String release(Imsi imsi);

}
