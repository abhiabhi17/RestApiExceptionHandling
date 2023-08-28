package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException e)
	{
		ErrorResponse errResponse=new ErrorResponse(HttpStatus.NOT_FOUND);
		errResponse.setStatusCode(400);
		errResponse.setStatusMessage(e.getMessage());
		return new ResponseEntity<>(errResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value={Exception.class, NullPointerException.class})
	public ResponseEntity<ErrorResponse> handleException1(ResourceNotFoundException e)
	{
		ErrorResponse errResponse=new ErrorResponse(HttpStatus.NOT_FOUND);
		errResponse.setStatusCode(500);
		errResponse.setStatusMessage("Null pointer Exception");
		return new ResponseEntity<>(errResponse,HttpStatus.NOT_FOUND);
	}
	

}
