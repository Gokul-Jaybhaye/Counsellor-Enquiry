package com.springbok.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbok.counsellerrepo.CounsellorRepo;
import com.springbok.dto.CounsellorDTO;
import com.springbok.entity.Counsellerentity;
@Service
public class CounsellorServiceImpl implements CounsellorService {
	@Autowired
	private CounsellorRepo counsellorrepo;
	@Override
	public CounsellorDTO loggin(CounsellorDTO counsellorDto) {
	Counsellerentity entity=counsellorrepo.findByEmailandPwd(counsellorDto.getEmail(), counsellorDto.getPwd());
		if(entity !=null) {
			CounsellorDTO dto=new CounsellorDTO();
			BeanUtils.copyProperties(entity,dto);
			return dto;
		}
		return null;
	}

	@Override
	public boolean uniqueEmailCheck(String email) {
		Counsellerentity entity= counsellorrepo.findByEmail(email);
		return entity==null;
		
	}

	@Override
	public boolean register(CounsellorDTO counsellorDTO) {
		// TODO Auto-generated method 
		Counsellerentity entity=new Counsellerentity();
		BeanUtils.copyProperties(counsellorDTO, entity);
		Counsellerentity saveentity=counsellorrepo.save(entity);
		return null!=saveentity.getCounsellorid();
	}

}
