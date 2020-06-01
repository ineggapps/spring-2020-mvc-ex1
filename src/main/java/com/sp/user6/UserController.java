package com.sp.user6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 @RequestParam
- key=value&key=value 형태로 넘어 온 파라미터를 메서드의 인수에 매핑하기 위해 사용하는 어노테이션
- 기본은 필수이므로 메서드의 인수에 파라미터가 넘어오지 않으면 400 Error을 발생시킨다.
- 필수가 아닌 형태로 변경 가능하고 기본값을 지정하거나 파라미터와 메서드 인수와 이름이 동일하지 않는 경우에도 매핑이 가능하다.
 */

@Controller("user6.userController")
@RequestMapping("/user6/*")
public class UserController {

	@GetMapping("main")
	public String main() {
		return "user6/main";
	}

	@GetMapping("request")
	public String submit(@RequestParam(defaultValue="0") int age, @RequestParam(value="gender",defaultValue="m") String g, Model model) {
		String s1 = "성인";
		String s2 = "남자";
		if (age < 19) {
			s1 = "미성년자";
		}
		if (g.equalsIgnoreCase("F")) {
			s2 = "여자";
		}
		model.addAttribute("age", age);
		model.addAttribute("gender", s2);
		model.addAttribute("result", s1);
		return "user6/view";
	}

}
