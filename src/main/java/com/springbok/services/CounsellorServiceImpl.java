package com.springbok.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbok.dto.CounsellorDTO;
import com.springbok.entity.CounsellorEntity;
import com.springbok.repo.CounsellorRepo;
@Service
public class CounsellorServiceImpl implements CounsellorService {
	@Autowired
	private CounsellorRepo counsellorRepo;
	
	
	@Override
	public CounsellorDTO loggin(CounsellorDTO counsellorDto) {
		CounsellorEntity entity=counsellorRepo.findByEmailAndPwd(counsellorDto.getEmail(), counsellorDto.getPwd());
		if(entity !=null) {
			CounsellorDTO dto=new CounsellorDTO();
			BeanUtils.copyProperties(entity,dto);
			return dto;
		}
		return null;
	}
	
	//UniqueEmailCheck
	@Override
	public boolean uniqueEmailCheck(String email) {
		// TODO Auto-generated method stub
		CounsellorEntity entity= counsellorRepo.findByEmail(email);
		return entity==null;
		
	}

	@Override
	public boolean register(CounsellorDTO counsellorDTO) {
		CounsellorEntity entity=new CounsellorEntity();
		BeanUtils.copyProperties(counsellorDTO, entity);
		CounsellorEntity saveEntity=counsellorRepo.save(entity);
		return null!=saveEntity.getCounsellorId();
		
	}

}
