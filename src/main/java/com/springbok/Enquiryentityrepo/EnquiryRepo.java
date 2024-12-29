package com.springbok.Enquiryentityrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbok.Enquiryentity.EnquiryEntity;

public interface EnquiryRepo extends JpaRepository<EnquiryEntity, Integer> {
	

}
