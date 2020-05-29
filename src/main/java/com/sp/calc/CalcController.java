package com.sp.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// /calc/request

@Controller("calc.calcController")
public class CalcController {
	@Autowired
	private CalcService calcService;
	
	@RequestMapping(value="/calc/request", method=RequestMethod.GET)
	public String input() {
		return "calc/input";
	}
	
	@RequestMapping(value="/calc/request", method=RequestMethod.POST)
//	public String result(int num1, int num2, String operator, Model model) { //로도 데이터를 받아서 처리할 수 있음.
	public String result(Calc dto, Model model) {
		String result = calcService.calculator(dto);
		model.addAttribute("result",result);//jsp에 전달할 값을 담기 위해서 addAttribute메서드를 이용한다.
		return "calc/result";
	}
	
}

