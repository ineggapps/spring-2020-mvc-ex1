package com.sp.insa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("insa.insaController")
public class InsaController {
	@Autowired
	private InsaService service;
	
	@RequestMapping(value="/insa/request", method=RequestMethod.GET)
	public String form() {
		return "insa/insa"; 
	}

	@RequestMapping(value="/insa/request", method=RequestMethod.POST)
	public String submit(Insa dto, Model model) {
		service.calculator(dto);
		
		model.addAttribute("dto", dto);
		
		return "insa/view"; 
	}
	
}
