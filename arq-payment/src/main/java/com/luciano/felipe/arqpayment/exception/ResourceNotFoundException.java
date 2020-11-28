package com.luciano.felipe.arqpayment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -3271923065722247658L;

	public ResourceNotFoundException(String message) {
		super(message);
	}


}
