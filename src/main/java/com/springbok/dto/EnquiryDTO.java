package com.springbok.dto;

import lombok.Data;

@Data
public class EnquiryDTO {
	private Integer enqId;
	private String stuName;
	private String stuPhone;
	
	private String classMode; 
    private String course;
    private String enqStatus;
}
