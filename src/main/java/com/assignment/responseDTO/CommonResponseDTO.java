package com.assignment.responseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * The Class CommonResponseDTO.
 * to send the response of apis
 * 
 * @author Rashi Mehta
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(Include.NON_NULL)
public class CommonResponseDTO {

	/** The status. */
	private Integer status;
	
	/** The message. */
	private String message;
	
	/** The error. */
	private String error;
	
	/** The data. */
	private Object data;
	
	/**
	 * Prepare response.
	 *
	 * @param message the message
	 * @param data the data
	 * @param status the status code
	 * @return the CommonResponseDTO response
	 */
	public static CommonResponseDTO prepareResponse(Integer status, String message, Object data) {
		return CommonResponseDTO.builder().status(status).message(message).data(data).build();
	}
}
