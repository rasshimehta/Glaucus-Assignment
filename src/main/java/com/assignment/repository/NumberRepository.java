package com.assignment.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.entity.Number;

/**
 * The Class NumberRepository.
 * to perform fetch, update, insert etc operation
 *  with number table in database
 * 
 * @author Rashi Mehta
 */

@Repository
public interface NumberRepository extends JpaRepository<Number, Integer>{

	Optional<Number> findByCountType(String countType);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE number SET count = count + 1 WHERE count_type = :countType " , nativeQuery = true)
	void incrementCountAndSave(String countType);
}
