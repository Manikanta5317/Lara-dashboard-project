package com.lara.projectApp02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lara.projectApp02.dto.BatchsDto;
import com.lara.projectApp02.dto.SuccessStatus;
import com.lara.projectApp02.service.BatchsService;

@RestController
@RequestMapping("batch")
@CrossOrigin("*")
public class BatchsController {
   
	@Autowired
	private BatchsService batchsService;
	
	@RequestMapping("save")
	public SuccessStatus save(@RequestBody BatchsDto batchDto) {
		return batchsService.save(batchDto); 
	}
}
