package com.springbok.counsellerrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbok.entity.Counsellerentity;

public interface CounsellorRepo extends JpaRepository<Counsellerentity, Integer> {

}
