package com.springbok.services;

import java.util.List;

//import com.springbok.dto.CounsellorDTO;
import com.springbok.dto.DashboardRepo;
import com.springbok.dto.EnquiryDTO;
import com.springbok.dto.EnquiryFilterDTO;

public interface EnquiryService {
	
	public DashboardRepo getDashboardInfo(Integer counsellorId);
	
	public boolean addEnquiry(EnquiryDTO enqDTO ,Integer counsellorId);
	
	public List<EnquiryDTO> getEnquiries(Integer counsellorId);
	public List<EnquiryDTO> getEnquiries(EnquiryFilterDTO filterDto,Integer counsellorId);
	
	public EnquiryDTO getEnquiriyById(Integer enqId);

}
