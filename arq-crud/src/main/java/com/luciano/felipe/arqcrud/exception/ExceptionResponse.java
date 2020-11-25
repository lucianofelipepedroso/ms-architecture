package com.luciano.felipe.arqcrud.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 901652090465761069L;
	
	private Date timeStamp;
	private String message;
	private String datails;

}
