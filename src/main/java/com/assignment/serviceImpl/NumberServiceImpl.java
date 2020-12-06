package com.assignment.serviceImpl;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.assignment.entity.Number;
import com.assignment.exception.PropertyNotFoundException;
import com.assignment.repository.NumberRepository;
import com.assignment.responseDTO.CommonResponseDTO;
import com.assignment.service.NumberService;
import com.assignment.utility.Constant;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class NumberServiceImpl.
 * to implement the various services 
 * of Number Service
 * 
 * @author Rashi Mehta
 */

@Service
@Slf4j
public class NumberServiceImpl implements NumberService{

	@Autowired
	NumberRepository numberRepository;
	
	ExecutorService executor = Executors.newCachedThreadPool();
	
	/**
	 * having implementation of logic 
	 * to increment the REQUEST_COUNT
	 * 
	 * @return CommonResponseDTO
	 */
	
	@Override
	public CommonResponseDTO numberIncrement() {
		log.info("------ NumberServiceImpl : numberIncrement ---------");
		Optional<Number> numberEntity = numberRepository.findByCountType("REQUEST_COUNT");
		if(numberEntity.isPresent()) {
			executor.submit(() -> numberRepository.incrementCountAndSave("REQUEST_COUNT"));
			return CommonResponseDTO.prepareResponse(HttpStatus.OK.value(), Constant.SUCCESS_MSG, null);	
		} else 
			throw new PropertyNotFoundException(HttpStatus.NOT_FOUND, Constant.PROPERTY_NOT_FOUND);
	}

}
