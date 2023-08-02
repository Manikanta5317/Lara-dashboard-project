package com.lara.projectApp01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.lara.projectApp01.dto.ClassScheduleDto;
import com.lara.projectApp01.dto.ClassScheduleRecords;
import com.lara.projectApp01.dto.DeleteDto;
import com.lara.projectApp01.dto.SuccessStatus;
import com.lara.projectApp01.model.ClassSchedule;
import com.lara.projectApp01.service.ClassScheduleService;

@RestController
@RequestMapping("schedule")
@CrossOrigin("*")
public class ClassScheduleController {
    
	@Autowired
	private ClassScheduleService classScheduleService;
	
	@PostMapping("save")
	public SuccessStatus save(@RequestBody ClassSchedule classSchedule) {
		return classScheduleService.save(classSchedule);
	}
	
	@PostMapping("update")
	public SuccessStatus update(@RequestBody ClassScheduleDto classScheduleDto) {
		return classScheduleService.update(classScheduleDto);
	}
	
    @DeleteMapping("delete")
	public SuccessStatus delete(@RequestBody  DeleteDto dto) {
		return classScheduleService.delete(dto);
	}
	
	@GetMapping("fetch")
	public Iterable<ClassSchedule>  fetch() {
		return classScheduleService.fetch();
	}
	
}
