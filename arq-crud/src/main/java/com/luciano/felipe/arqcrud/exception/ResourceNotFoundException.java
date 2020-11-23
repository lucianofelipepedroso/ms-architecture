package com.luciano.felipe.arqcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4883916392648542443L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
