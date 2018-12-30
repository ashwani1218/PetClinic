package com.ashwani.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashwani.Services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerSerivce) {
		super();
		this.ownerService = ownerSerivce;
	}

	@RequestMapping({"","/index","/index.html"})
	public String ListOwners(Model model) {
		model.addAttribute("owners",ownerService.findAll());
		return "/Owners/index";
	}
}
