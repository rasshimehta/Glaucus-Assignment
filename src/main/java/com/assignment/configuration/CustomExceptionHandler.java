package com.assignment.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.exception.PropertyNotFoundException;
import com.assignment.responseDTO.CommonResponseDTO;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(PropertyNotFoundException.class)
	protected ResponseEntity<Object> handleWorkflowException(PropertyNotFoundException ex) {
		CommonResponseDTO response = CommonResponseDTO.builder().error(ex.getLocalizedMessage())
				.status(ex.getHttpStatus().value()).build();
		return new ResponseEntity<>(response, ex.getHttpStatus());
	}
	
}
