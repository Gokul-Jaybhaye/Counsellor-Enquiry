package com.springbok.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springbok.dto.DashboardRepo;
import com.springbok.dto.EnquiryDTO;
import com.springbok.dto.EnquiryFilterDTO;
import com.springbok.entity.CounsellorEntity;
import com.springbok.entity.EnquiryEntity;
import com.springbok.repo.CounsellorRepo;
import com.springbok.repo.EnquiryRepo;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryRepo enqRepo;
	
	@Autowired
	private CounsellorRepo counsellorRepo;
	@Override
	public DashboardRepo getDashboardInfo(Integer counsellorId) {
		
		
		List<EnquiryEntity> enquslist =enqRepo.findByCounsellorCounsellorId(counsellorId);
		DashboardRepo dto=new DashboardRepo();
		dto.setTotalEnqCount(enquslist.size());
		int openCnt=enquslist.stream()
				          .filter(enq->enq.getEnqStatus()
			              .equals("OPEN"))
				          .collect(Collectors.toList())
				          .size();
		dto.setOpenEnqCount(openCnt);
		
		int enrollCnt=enquslist.stream()
		          .filter(enq->enq.getEnqStatus()
	              .equals("ENROLL"))
		          .collect(Collectors.toList())
		          .size();	
		dto.setEnrolledEnqCount(enrollCnt);
		int lostCnt=enquslist.stream()
		          .filter(enq->enq.getEnqStatus()
	              .equals("LOST"))
		          .collect(Collectors.toList())
		          .size();
		dto.setLostEnqCount(lostCnt);
		
		return dto;
	
	}

	@Override
	public boolean addEnquiry(EnquiryDTO enqDTO, Integer counsellorId) {
		EnquiryEntity entity=new EnquiryEntity();
		BeanUtils.copyProperties(enqDTO, entity);
		Optional<CounsellorEntity> byId=counsellorRepo.findById(counsellorId);
		if(byId.isPresent()) {
			CounsellorEntity counsellor=byId.get();
			entity.setCounsellor(counsellor);
		}
		EnquiryEntity save= enqRepo.save(entity);
		return save.getEnqId()!=null;
		
	}

	@Override
	public List<EnquiryDTO> getEnquiries(Integer counsellorId) {
		List<EnquiryDTO> enqsDto=new ArrayList<>();
		List<EnquiryEntity> enqlist  = enqRepo.findByCounsellorCounsellorId(counsellorId);
		for(EnquiryEntity entity:enqlist) {
			EnquiryDTO dto=new EnquiryDTO();
			BeanUtils.copyProperties( entity,dto);
			enqsDto.add(dto);
		}
		return enqsDto;
		
	}

	@Override
	public List<EnquiryDTO> getEnquiries(EnquiryFilterDTO filterDto, Integer counsellorId) {
		EnquiryEntity entity=new EnquiryEntity();
		if(filterDto.getClassMode()!=null && 
				!filterDto.getClassMode().equals("")) {
			entity.setClassMode(filterDto.getClassMode());
		}
		
		if(filterDto.getCourse()!=null && 
				!filterDto.getCourse().equals("")) {
			entity.setCourse(filterDto.getCourse());
		}
		
		if(filterDto.getEnqStatus()!=null && 
				!filterDto.getEnqStatus().equals("")) {
			entity.setEnqStatus(filterDto.getEnqStatus());
		}
		
		CounsellorEntity counsellor=new CounsellorEntity();
		counsellor.setCounsellorId(counsellorId);
		entity.setCounsellor(counsellor);
		
		Example<EnquiryEntity> of=Example.of(entity);
		List<EnquiryEntity> all=enqRepo.findAll(of);
		
		List<EnquiryDTO> enqsDto=new ArrayList<>();

		for(EnquiryEntity ent:all) {
			EnquiryDTO dto=new EnquiryDTO();
			BeanUtils.copyProperties( ent,dto);
			enqsDto.add(dto);
		}
		
		return enqsDto;
		
	}

	@Override
	public EnquiryDTO getEnquiriyById(Integer enqId) {
		Optional<EnquiryEntity> byId=enqRepo.findById(enqId);
		if(byId.isPresent()) {
			EnquiryEntity enquiryEntity=byId.get();
			EnquiryDTO dto=new EnquiryDTO();
			BeanUtils.copyProperties(enquiryEntity, dto);
			return dto;
		}
		return null;
		
	}

}
