package com.springbok.services;

import com.springbok.dto.CounsellorDTO;

public interface CounsellorService {
	public CounsellorDTO loggin(CounsellorDTO counsellorDto);
	public boolean uniqueEmailCheck(String email);
	public boolean register(CounsellorDTO counsellorDTO);


}
