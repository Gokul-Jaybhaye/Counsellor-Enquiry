package com.springbok.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbok.counsellerrepo.CounsellorRepo;
import com.springbok.dto.CounsellorDTO;
@Service
public class CounsellorServiceImpl implements CounsellorService {
	@Autowired
	private CounsellorRepo counsellorrepo;
	@Override
	public CounsellorDTO loggin(CounsellorDTO counsellorDto) {
		counsellorrepo.findByEmailandPwd(CounsellorDTO, null)
		return null;
	}

	@Override
	public boolean uniqueEmailCheck(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(CounsellorDTO counsellorDTO) {
		// TODO Auto-generated method stub
		return false;
	}

}
