//package com.lara.projectApp02.service;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.lara.projectApp02.dto.SuccessStatus;
//import com.lara.projectApp02.entity.ClassSchedule;
//import com.lara.projectApp02.repository.ClassScheduleRepository;
//
//import jakarta.transaction.Transactional;
//
//@Service
//@Transactional
//public class ClassScheduleService {
//    @Autowired
//	private ClassScheduleRepository classScheduleRepository;
//    
//    public SuccessStatus save(ClassSchedule classSchedule) {
//    	var status=SuccessStatus.builder()
//    			  .message("please enter all details")
//    			  .status(false)
//    			  .build();
//    	
//    	//checking for null 
//    	if(classSchedule.getTime()==null|| classSchedule.getBatchName()==null||classSchedule.getInstructor()==null
//    			||classSchedule.getTopic()==null|| classSchedule.getClassType()==null ) {
//    		return status;
//    	}
//
//    	//checking already present data
//        if(classScheduleRepository.findByBatchName(classSchedule.getBatchName()).isPresent()||
//        	classScheduleRepository.findByInstructor(classSchedule.getInstructor()).isPresent()) {
//        	status.setMessage("already schedule is present with same date");
//        	return status;
//        }
////        LocalTime time=LocalTime.now();
//    	 LocalDate currentDate = LocalDate.now();
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
//        
//        classSchedule.setDate(currentDate.format(formatter));
//        classSchedule.setBatchName(classSchedule.getBatchName());
//        classSchedule.setInstructor(classSchedule.getInstructor());;
//        classSchedule.setTopic(classSchedule.getTopic());
//        classSchedule.setClassType(classSchedule.getClassType());
//        classSchedule.setTime(classSchedule.getTime());
//        classScheduleRepository.save(classSchedule);
//        status.setMessage("saved schedule data");
//        status.setStatus(true);
//        return status;
//    }
//    
////    public SuccessStatus update(ClassScheduleDto dailyDto) {
////    	var status=SuccessStatus.builder()
////    			  .message("please enter all details")
////    			  .status(false)
////    			  .build();
////    	
////    	//checking for null 
////    	if(dailyDto.getDate()==null || dailyDto.getBatchName()==null|| dailyDto.getInstructor()==null||
////    		dailyDto.getTopic()==null|| dailyDto.getDate()==null||dailyDto.getTime()==null) {
////    		return status;
////    	}
////      
////    	Optional<ClassSchedule> fetchedRecords=dailyScheduleRepository.findById(dailyDto.getId());
////    	//checking already present data
////        if(fetchedRecords.isEmpty()) {
////        	status.setMessage("already schedule is present with same date");
////        	return status;
////        }
////        fetchedRecords.get().setDate(fetchedRecords.get().getDate());
////        fetchedRecords.get().setBatchName(dailyDto.getBatchName());
////        fetchedRecords.get().setInstructor(dailyDto.get);;
////        fetchedRecords.get().setTopic(dailyDto.getTopic());
////        fetchedRecords.get().setStartTime(dailyDto.getStartTime());
////        fetchedRecords.get().setEndTime(dailyDto.getEndTime());
////        dailyScheduleRepository.save(fetchedRecords.get());
////        status.setMessage("saved schedule data");
////        status.setStatus(true);
////        return status;
////    }
////    
////    public SuccessStatus Reset(ClassScheduleDto dailyDto) {
////    	var status=SuccessStatus.builder()
////    			   .message("please enter all details of schedule")
////    			   .status(false)
////    			   .build();
////    	if(dailyDto.getDate()==null || dailyDto.getBatchName()==null|| dailyDto.getTrainerName()==null||
////        		dailyDto.getTopic()==null|| dailyDto.getDate()==null||dailyDto.getEndTime()==null) {
////    		return status;
////    	}
////    	
////    	Optional<ClassSchedule> fetchedRecord=dailyScheduleRepository.findById(dailyDto.getId());
////    	if(fetchedRecord.isEmpty()) {
////    		status.setMessage("records not existing");
////    		return status;
////    	}
//////    	dailyScheduleRepository.deleteById(fetchedRecord.get().getId());
////    	if(fetchedRecord.get().getDate()!=dailyDto.getDate()) {
////	        fetchedRecord.get().setDate(dailyDto.getDate());
////	    	fetchedRecord.get().setBatchName(dailyDto.getBatchName());
////	    	fetchedRecord.get().setTrainerName(dailyDto.getTrainerName());
////	    	fetchedRecord.get().setTopic(dailyDto.getTopic());
////	    	fetchedRecord.get().setStartTime(dailyDto.getStartTime());
////	    	fetchedRecord.get().setEndTime(dailyDto.getEndTime());
////	    	dailyScheduleRepository.save(fetchedRecord.get());
////	    	status.setMessage("updated schedule details");
////	    	status.setStatus(true);
////	    	return status;
////    	}
////    	status.setMessage("please modify schedule data");
////    	return status;
////    }
//}
