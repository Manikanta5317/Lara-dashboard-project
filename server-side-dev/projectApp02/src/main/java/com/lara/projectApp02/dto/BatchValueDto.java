package com.lara.projectApp02.dto;

public class BatchValueDto {
    private Long id;
    
    private String batchName;
    private String time;
    
    BatchValueDto(String batchName,String time){
    	this.time=time;
    	this.batchName=batchName;
    }
}
