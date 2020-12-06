package com.assignment.configuration;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.entity.Number;
import com.assignment.repository.NumberRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PostConstructImplementation {

	@Autowired
	NumberRepository numberRepository;
	
	@PostConstruct
    public void init() {
		log.info("----------- PostConstructImplementation : init ------------");
		Optional<Number> numberEntity = numberRepository.findByCountType("REQUEST_COUNT");
		if(!numberEntity.isPresent()) {
			numberRepository.save(Number.builder().countType("REQUEST_COUNT").count(0).build());
		}
    }
}
