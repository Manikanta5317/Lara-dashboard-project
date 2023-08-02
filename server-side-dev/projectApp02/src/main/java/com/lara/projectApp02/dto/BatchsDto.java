package com.lara.projectApp02.dto;

import java.time.LocalDate;

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
public class BatchsDto {
   
//   @GeneratedValue(strategy = GenerationType.AUTO)
//   private Long id;	
   
   private String date;
   
   private String batchName;
   
   private String subjectName;
   
   private String teacherName;
   
   private String time;

}
