package com.tg.healthcaremvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tg.healthcaremvcapp.models.Clinic;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String loadIndex(Model model) {
		
		model.addAttribute("clinic", new Clinic());
		return "index.html";
	}
	
	@PostMapping("/register")
	public String saveClinicData(@ModelAttribute("clinic")Clinic clinic, 
			Model model) {
		
		if(clinic.getClinicId()!=null)
			return "success.html";
		else
			return "redirect:/index";	
		
	}

}
