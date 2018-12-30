package com.ashwani.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Owners")
@Controller
public class OwnerController {

	@RequestMapping({"","/Index","/Index.html"})
	public String ListOwners() {
		return "/Owners/index";
	}
}
