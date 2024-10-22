package com.abhaynoor.Hotel_Management_System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex){
		StringBuilder errorMessage = new StringBuilder();
		ex.getBindingResult().getFieldErrors().forEach(error->
				errorMessage.append(error.getDefaultMessage()).append("."));
		return new ResponseEntity<>(errorMessage.toString(),HttpStatus.BAD_REQUEST);
	}

}
