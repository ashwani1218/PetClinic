package com.ashwani.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashwani.Services.VetService;

@Controller
public class VetController {

	private final VetService vetService;
	
	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@RequestMapping({"/vets/index","/vets/index.html","/vets.html"})
	public String ListVets(Model model) {
		model.addAttribute("vets",vetService.findAll());
		return "/Vets/index";
	}
	
}
