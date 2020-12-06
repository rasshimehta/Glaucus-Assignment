package com.assignment.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class PropertyNotFoundException.
 * 
 * @author Rashi Mehta
 */

@Getter
@Setter
public class PropertyNotFoundException extends RuntimeException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4265643737002567524L;
	
	/** The Constant httpStatus. */
	private  HttpStatus httpStatus ;
	
	/**
	 * Instantiates a new property not found exception.
	 *
	 * @param message the message
	 */

	public PropertyNotFoundException(String message) {
		super(message);
		
	}

	/**
	 * Instantiates a new property not found exception.
	 *
	 * @param message the message
	 * @param httpStatus the httpStatus
	 */
	public PropertyNotFoundException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}
	
}
