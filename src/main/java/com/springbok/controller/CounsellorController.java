package com.springbok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbok.dto.CounsellorDTO;
import com.springbok.dto.DashboardRepo;
import com.springbok.services.CounsellorService;
import com.springbok.services.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {
	
	@Autowired
	private CounsellorService counsellorService;
	
	@Autowired
	private EnquiryService enqService;
	@GetMapping("/")
	public String index(Model model) {
		CounsellorDTO cdto=new CounsellorDTO();
		model.addAttribute("counsellor", cdto);
		return "index";
		
	}
	
	@PostMapping("/login")
	public String handleLogin(HttpServletRequest req, @ModelAttribute CounsellorDTO counsellor,Model model) {
		
		CounsellorDTO counsellorDto=counsellorService.loggin(counsellor);
		if(counsellorDto==null) {
			model.addAttribute("emsg", "Invalid Credintial");
		    return "index";
	   }else {
		   Integer counsellorId= counsellorDto.getCounsellorId();
		   HttpSession session= req.getSession(true);
		   session.setAttribute("counsellorId", counsellorId);
		   DashboardRepo dashboardDto=enqService.getDashboardInfo(counsellorId);
		   model.addAttribute("dashboardDto", dashboardDto);
		   return"dashboard";
	   }
	}

}
