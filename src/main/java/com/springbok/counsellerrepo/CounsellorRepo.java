package com.springbok.counsellerrepo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.springbok.entity.Counsellerentity;
//@Repository
public interface CounsellorRepo extends JpaRepository<Counsellerentity, Integer> {
	public Counsellerentity findByEmailandPwd(String email,String pwd);
	public Counsellerentity findByEmail(String email);

}
