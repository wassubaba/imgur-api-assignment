package com.imgur.assignment.imgurapiassignment.exception;



import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmptyInputException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;
	
	
	/*
	public EmptyInputException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmptyInputException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	*/
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	@Override
	public String toString() {
		return "EmptyInputException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	
	

}
