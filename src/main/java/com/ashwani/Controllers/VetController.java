package com.ashwani.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

	@RequestMapping({"/vets/index","/vets/index.html"})
	public String ListVets() {
		return "/Vets/index";
	}
	
}
