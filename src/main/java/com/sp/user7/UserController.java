package com.sp.user7;

import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("user7.userController")
@RequestMapping("/user7/*")
public class UserController {

	@GetMapping("request")
	public String form() {
		return "user7/write";
	}

	@PostMapping("request")
	public String submit(@RequestParam Map<String, String> paramMap, Model model) {
		//Map으로 파라미터를 받고 싶다면 @RequestParam 어노테이션을 붙여야 한다.
		//Map으로 파라미터를 받는 경우 checkbox로 다중 선택된 항목은 하나의 값밖에 받지 못한다. (왜냐하면 Map은 중복될 수 없는 해시 구조이기 때문)
		String s;
		s = "이름: " + paramMap.get("name") + "<br/>";
		s += "나이: " + paramMap.get("age") + "<br/>";
//		s += "취미: " + paramMap.get("hobby") + "<br/>";
		s += "취미: " ;
		
		Iterator<String> it = paramMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(key.startsWith("hobby")) {
				String value = paramMap.get(key);
				s += value + " ";
			}
		}
		
		model.addAttribute("result", s);
		return "user7/view";
	}
}
