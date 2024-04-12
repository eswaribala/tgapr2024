package com.tg.healthcaremvcapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tg.healthcaremvcapp.models.Clinic;
import com.tg.healthcaremvcapp.sevices.ClinicImplService;
import com.tg.healthcaremvcapp.sevices.ClinicService;

@Controller
public class IndexController {
	
	@Autowired
	private ClinicService clinicService;
	
	@GetMapping("/index")
	public String loadIndex(Model model) {
		
		model.addAttribute("clinic", new Clinic());
		return "index.html";
	}
	
	@PostMapping("/register")
	public String saveClinicData(@ModelAttribute("clinic")Clinic clinic, 
			Model model) {
		Clinic clinicResponse=null;
		if(clinic.getClinicId()!=null) {
		 	clinicResponse=this.clinicService.addClinic(clinic);
		 	if(clinicResponse!=null)
		 	{	
		 		model.addAttribute("clinic", clinicResponse);
			   return "success.html";
		 	}
		 	else
		 		return "redirect:/index";	
		}
		else
			return "redirect:/index";	
		
	}

}
