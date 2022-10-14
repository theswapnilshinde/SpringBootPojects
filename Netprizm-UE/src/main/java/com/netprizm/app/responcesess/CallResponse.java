package com.netprizm.app.responcesess;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallResponse {

	Integer count;
	String msg;
	boolean status;
	Object data;
	//String errorCode;
	//String statusCode;
	
	public CallResponse(String msg, boolean status) {
		super();
		this.msg = msg;
		this.status = status;
	}
	public CallResponse(int count, String msg, boolean status, Object data) {
		super();
		this.count = count;
		this.msg = msg;
		this.status = status;
		this.data = data;
	}
	public CallResponse(String msg, boolean status, String errorCode) {
		super();
		this.msg = msg;
		this.status = status;
	//	this.errorCode = errorCode;
	}
	
	public CallResponse(String msg2, int created) {
		this.msg = msg2;
	//	this.status = created;
	}
	public CallResponse(String string) {
		this.msg=string;
	}
	
}
