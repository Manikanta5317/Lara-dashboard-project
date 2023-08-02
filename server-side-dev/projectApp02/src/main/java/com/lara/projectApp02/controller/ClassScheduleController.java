//package com.lara.projectApp02.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.lara.projectApp02.dto.SuccessStatus;
//import com.lara.projectApp02.entity.ClassSchedule;
//import com.lara.projectApp02.service.ClassScheduleService;
//
//@RestController
//@RequestMapping("classchedule")
//@CrossOrigin("*")
//public class ClassScheduleController {
//    @Autowired 
//	private ClassScheduleService classScheduleService;
//    
//    @PostMapping("/save")
//    public SuccessStatus save(@RequestBody ClassSchedule classSchedule) {
//    	return classScheduleService.save(classSchedule);
//    }
//}
