package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.responseDTO.CommonResponseDTO;
import com.assignment.service.NumberService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class NumberController.
 * Rest Controller annotated class having api end points
 * 
 * @author Rashi Mehta
 */

@RestController
@RequestMapping("/number")
@Slf4j
public class NumberController {
	
	/** The numberService. */
	@Autowired
	NumberService numberService;

	/**
	 * end point of increment number api 
	 * to increment the REQUEST_COUNT in database
	 * 
	 * @return ResponseEntity of CommonResponseDTO
	 */
	@PostMapping("/increment")
	public  ResponseEntity<CommonResponseDTO> numberIncrement() {
		log.info("-------- NumberController : numberIncrement ---------");
		CommonResponseDTO commonResponseDTO = numberService.numberIncrement();
		return new ResponseEntity<>(commonResponseDTO, HttpStatus.OK);
	}
}
