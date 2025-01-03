package com.springbok.dto;

import lombok.Data;

@Data
public class DashboardRepo {
	private Integer totalEnqCount;
	private Integer openEnqCount;
	private Integer enrolledEnqCount;
	private Integer lostEnqCount;

}
