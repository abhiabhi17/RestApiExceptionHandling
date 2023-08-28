package com.example.exceptions;

import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


import org.springframework.http.HttpStatus;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponse {
	private Integer statusCode;
	private String statusMessage;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public ErrorResponse(Integer statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}
	public ErrorResponse(HttpStatus notFound) {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ErrorResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", getStatusCode()="
				+ getStatusCode() + ", getStatusMessage()=" + getStatusMessage() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
