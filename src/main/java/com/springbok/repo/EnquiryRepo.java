package com.springbok.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.springbok.entity.EnquiryEntity;


//@Repository
public interface EnquiryRepo extends JpaRepository<EnquiryEntity, Integer> {
	public List<EnquiryEntity> findByCounsellorCounsellorId(Integer counsellorId);
	

}