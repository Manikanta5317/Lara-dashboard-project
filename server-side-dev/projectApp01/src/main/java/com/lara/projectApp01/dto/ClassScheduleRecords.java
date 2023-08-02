package com.lara.projectApp01.dto;

import java.util.List;

import com.lara.projectApp01.model.ClassSchedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassScheduleRecords {
   
	private String message;
	
	private boolean status;
	
	private List<ClassSchedule> listRecords;
}
