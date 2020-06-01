package com.sp.test1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("test1.userController")
@RequestMapping("/test1/*")
public class UserController {
	
	@GetMapping("/request")
	public String form() {
		return "test1/write";
	}
	
	@PostMapping("/request")
	public String submit(@ModelAttribute("vo") User dto) {
		/*
		 	req.setAttribute("vo",dto)의 역할을 한다.
		 	@ModelAttribute: 메서드의 인수에서 사용되는 경우 JSP파일에 반환되는 Model 객체에 속성값을 주입하거나 바인딩할 수 있음.
		 */
		return "test1/view";	
	}
	
	/*
	 @ModelAttribute가 메서드의 위 부분에 설정한 경우 @ModelAttribute는 
	 @RequestMApping보다 먼저 실행된다.	
	 * */
	
	@ModelAttribute("memberTypes")
	public List<String> types() throws Exception{
		List<String> list = new ArrayList<>();
		list.add("일반 회원");
		list.add("기업 회원");
		list.add("관리자");
		
		return list;
	}
}
