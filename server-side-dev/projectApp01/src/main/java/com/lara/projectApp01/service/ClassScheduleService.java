package com.lara.projectApp01.service;

import java.lang.StackWalker.Option;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lara.projectApp01.dto.ClassScheduleDto;
import com.lara.projectApp01.dto.ClassScheduleRecords;
import com.lara.projectApp01.dto.DeleteDto;
import com.lara.projectApp01.dto.SuccessStatus;
import com.lara.projectApp01.model.ClassSchedule;
import com.lara.projectApp01.repository.ClassScheduleRepository;

import jakarta.transaction.Transactional;
import lombok.experimental.var;

@Service
@Transactional
public class ClassScheduleService {
	
	@Autowired
	private ClassScheduleRepository classScheduleRepo;
	
	public SuccessStatus save(ClassSchedule classSchedule) {
		var status=SuccessStatus.builder()
				   .message("please enter all details")
				   .status(false)
				   .build();
		
		if(classSchedule.getBatchName()==null|| classSchedule.getInstructor()==null|| classSchedule.getClassType()==null
		  || classSchedule.getTopic()==null|| classSchedule.getTime()==null) {
		    return status;	
		}
		
		LocalDate date=LocalDate.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
		classSchedule.setDate(date.format(formatter));
		classSchedule.setBatchName(classSchedule.getBatchName());
		classSchedule.setInstructor(classSchedule.getInstructor());
		classSchedule.setClassType(classSchedule.getClassType());
		classSchedule.setTopic(classSchedule.getTopic());
		classSchedule.setTime(classSchedule.getTime());
		classScheduleRepo.save(classSchedule);
		
		status.setMessage("successful saved details");
		status.setStatus(true);
		return status;
	}
	
	public SuccessStatus update(ClassScheduleDto classScheduleDto) {
		var status=SuccessStatus.builder()
				   .message("please enter all details")
				   .status(false)
				   .build();
		if(classScheduleDto.getBatchName()==null|| classScheduleDto.getInstructor()==null|| classScheduleDto.getClassType()==null
		  || classScheduleDto.getTopic()==null|| classScheduleDto.getTime()==null) {
			return status;
		}
		
		Optional<ClassSchedule> fetchedRecords=classScheduleRepo.readClassScheduleRecord(classScheduleDto.getTime()
				                                                             ,classScheduleDto.getBatchName());
		if(fetchedRecords.isEmpty()) {
			status.setMessage("No such record");
			return status;
		}
			LocalDate date=LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
			 
			fetchedRecords.get().setTime(classScheduleDto.getTime());
			fetchedRecords.get().setBatchName(fetchedRecords.get().getBatchName());
			fetchedRecords.get().setTime(fetchedRecords.get().getTime());
			fetchedRecords.get().setInstructor(classScheduleDto.getInstructor());
			fetchedRecords.get().setClassType(classScheduleDto.getClassType());
			fetchedRecords.get().setTopic(classScheduleDto.getTopic());
			
			classScheduleRepo.save(fetchedRecords.get());
			status.setMessage("successful updated");
			status.setStatus(true);
			return status;
		
	}
	
	public SuccessStatus delete(DeleteDto dto) {
		var status=SuccessStatus.builder()
				  .message("No such record is present")
				  .status(false)
				  .build();
		
		Optional<ClassSchedule> fetchedRecord=classScheduleRepo.findById(dto.getId());
		
		if(fetchedRecord.get()==null) {
		   return status;	
		}
		
		classScheduleRepo.deleteById(dto.getId());
		status.setMessage("records is deleted");
		status.setStatus(true);
		return status;
	}
	
	public Iterable<ClassSchedule> fetch() {
//		var status =ClassScheduleRecords.builder()
//				    .message("Records are not avaliable")
//				    .status(false)
//				    .build();
		Iterable<ClassSchedule> fetchedClassRecords=classScheduleRepo.findAll();
		
		return fetchedClassRecords;
//		if(((List<ClassSchedule>)classScheduleRepo.findAll()).size()==0) {
//			return status;
//		}
//		
//		status.setListRecords(fetchedClassRecords);
//		status.setMessage("fetch all records");
//		status.setStatus(true);
//		return status;
	}

}
