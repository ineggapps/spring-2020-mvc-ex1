package com.sp.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("hr.hrController")
@RequestMapping("/hr")
public class HrController {
	@Autowired
	private HrServiceImpl hrService;
	
	@GetMapping("/request")
	public String form() {

		return "hr/write";
	}

	@PostMapping("/request")
	public String result(Human dto, Model model) {
		dto = hrService.calcAutomatically(dto);
		model.addAttribute("dto", dto);
		return "hr/result";
	}
}
