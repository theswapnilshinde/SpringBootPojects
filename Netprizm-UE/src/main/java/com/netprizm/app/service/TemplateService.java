package com.netprizm.app.service;

import com.netprizm.app.io.dto.TemplateDto;
import com.netprizm.app.responcesess.CallResponse;

public interface TemplateService {

	// String deleteTowerData(int id);

	TemplateDto saveDto(TemplateDto requestTemplate);

	CallResponse saveResponce(TemplateDto templateDto);

}
