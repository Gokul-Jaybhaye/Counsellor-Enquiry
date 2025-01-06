package com.springbok.repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.springbok.entity.CounsellorEntity;

public interface CounsellorRepo extends JpaRepository<CounsellorEntity, Integer> {
	public CounsellorEntity findByEmailAndPwd(String email, String pwd);
	public CounsellorEntity findByEmail(String email);

}
