package com.lara.projectApp01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lara.projectApp01.model.ClassSchedule;

import jakarta.transaction.Transactional;

@Transactional
public interface ClassScheduleRepository  extends JpaRepository<ClassSchedule, Long>{
	
    @Query("SELECT c FROM ClassSchedule c WHERE c.time = :time AND c.batchName = :batchName")
    public Optional<ClassSchedule> readClassScheduleRecord(@Param("time") String time, @Param("batchName") String batchName);
   
}
