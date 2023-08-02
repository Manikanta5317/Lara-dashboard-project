package com.lara.projectApp02.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lara.projectApp02.dto.BatchValueDto;
import com.lara.projectApp02.entity.Batchs;

public interface BatchsRepository extends JpaRepository<Batchs, Long> {
	

	@Query("SELECT NEW com.lara.projectApp02.dto.BatchValueDto(b.batchName, t.time) " +
		       "FROM Batchs b " +
		       "JOIN b.timings t " +
		       "WHERE t.time = :time OR b.batchName = :batchName")
public Optional<BatchValueDto> findByTimeOrBatchName(@Param("time") String time, @Param("batchName") String batchName);