package com.springbok.entity;

import java.util.List;

import com.springbok.Enquiryentity.EnquiryEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="Counsellor_tab")
@Setter
@Getter
public class Counsellerentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer counsellorid;
	private String name;
	private String email;
	private String pwd;
	private String phno;
	@OneToMany(mappedBy = "counsellor", cascade = CascadeType.ALL)
	private List<EnquiryEntity> enquiries;

}
