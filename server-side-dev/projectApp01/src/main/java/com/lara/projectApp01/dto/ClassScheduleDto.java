package com.lara.projectApp01.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassScheduleDto {
	private Long id;
	
	private String time;
	
	private String batchName;
	
	private String instructor;
	
	private String classType;
	
	private String topic;
}
