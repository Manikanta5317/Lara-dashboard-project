package com.lara.projectApp02.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lara.projectApp02.dto.BatchsDto;
import com.lara.projectApp02.dto.SuccessStatus;
import com.lara.projectApp02.entity.Batchs;
import com.lara.projectApp02.entity.Subjects;
import com.lara.projectApp02.entity.Teachers;
import com.lara.projectApp02.entity.Timings;
import com.lara.projectApp02.repository.BatchsRepository;
import com.lara.projectApp02.repository.SubjectsRepository;
import com.lara.projectApp02.repository.TeachersRepository;
import com.lara.projectApp02.repository.TimingsRepository;

@Service
public class BatchsService {
   
	@Autowired
	private BatchsRepository batchsRepo;
	 
	@Autowired
	private SubjectsRepository subjectsRepo;
	
	@Autowired
	private TeachersRepository teachersRepo;
	
	@Autowired
	private TimingsRepository timingsRepo;
	
	public SuccessStatus save(BatchsDto batchDto) {
		var status= SuccessStatus.builder()
				    .message("please enter all details")
				    .status(false)
				    .build();
		if(batchDto.getTime()==null || batchDto.getBatchName()==null|| batchDto.getSubjectName()==null
			||batchDto.getTeacherName()==null) return status;
		
//		LocalTime time=LocalTime.now();
		if(batchsRepo.findByTimeOrBatchName(batchDto.getTime(), batchDto.getBatchName()).isPresent()) {
			status.setMessage("already class schedule assigned for this timing");
			return status;
		}
	    LocalDate currentDate = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
	   
		Batchs batch=Batchs.builder()
				    .date(currentDate.format(formatter))
				    .batchName(batchDto.getBatchName())
				    .build();
		
		 Timings timings=Timings.builder()
 		        .time(batchDto.getTime())
 		        .build();
		
		Teachers teacher=Teachers.builder()
				        .teacherName(batchDto.getTeacherName())
				        .build();
		
		Subjects subject=Subjects.builder()
				         .subjectName(batchDto.getSubjectName())
				         .build();
	    timingsRepo.save(timings);
		batchsRepo.save(batch);
		teachersRepo.save(teacher);
		subjectsRepo.save(subject);
		
		status.setMessage("saved class schedule details");
		status.setStatus(true);
		return status;
	}
}
