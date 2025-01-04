package com.springbok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbok.dto.CounsellorDTO;

@Controller
public class CounsellorController {
	@GetMapping("/")
	public String index(Model model) {
		CounsellorDTO cdto=new CounsellorDTO();
		model.addAttribute("counsellor", cdto);
		return "index";
		
	}

}
