package com.srm.hirehub.hirehub_portal.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public  ResponseEntity<?> handleUserException(UserException e) {
		return ResponseEntity.badRequest().body(e.getValidationMessage());
	}

}
