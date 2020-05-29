package com.sp.user5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("user5.userController")
public class UserController {
	
//	@RequestMapping(value="/user5/request", method=RequestMethod.GET)
	@GetMapping("/user5/request")
	public String form() {
		return "user5/write";
	}
	
	/*
//	@RequestMapping(value="/user5/request", method=RequestMethod.POST)
	@PostMapping("/user5/request")
	public String result(User dto, Model model) {
//		model.addAttribute(attributeValue);
		String s= "이름: " + dto.getName() + "...";
		s += "취미:";
		if(dto.getHobby()!=null){
			for(String h: dto.getHobby()) {
				s += " " + h  ;
			}
		}
		model.addAttribute("result", s);
		return "user5/view";
	}*/
	/*
	@PostMapping("/user5/request")
	public String submit(String name, String hobby, Model model) {
		//동일한 이름을 가진 파라미터를 하나의 String 변수로 넘겨 받으면 
		// 운동,음악처럼 ","로 구분지어 넘어온다.
		String s="이름: " + name + ", 취미: " +hobby;
//		System.out.println(hobby);//음악,웃기
		model.addAttribute("result", s);
		return "user5/view";
	}*/
	
	@PostMapping("/user5/request")
	//단, 파라미터에서 List와 같은 인터페이스로는 가질 수 어노테이션을 사용하지 않고서는 List<>로는 파라미터 인수를 받아낼 수 없다.
	public String submit(String name, String[] hobby, Model model) {
		String s="이름: " + name + ", 취미: ";
		if(hobby!=null) {
			for(String h: hobby) {
				s += " " + h;
			}
		}else {
			s += "(없음)";
		}
//		System.out.println(hobby);//음악,웃기
		model.addAttribute("result", s);
		return "user5/view";
	}
	
}
