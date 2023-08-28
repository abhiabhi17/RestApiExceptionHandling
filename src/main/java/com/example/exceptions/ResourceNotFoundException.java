package com.example.exceptions;

import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
	public ResourceNotFoundException(String exception)
	{
	
		super(exception);
	}

}
