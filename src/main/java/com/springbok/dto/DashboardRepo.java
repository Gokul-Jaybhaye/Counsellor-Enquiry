package com.springbok.dto;

import lombok.Data;

@Data
public class DashboardRepo {
	private Long totalEnqCount;
	private Long openEnqCount;
	private Long enrolledEnqCount;
	private Long lostEnqCount;

}
