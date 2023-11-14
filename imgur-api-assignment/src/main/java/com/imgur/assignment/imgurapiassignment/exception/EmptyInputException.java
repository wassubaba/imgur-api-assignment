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

}
