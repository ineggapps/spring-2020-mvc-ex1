package com.sp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //컨트롤러 역할을 하는 클래스에 명명. 객체는 자동으로 생성된다. (@Controller ≒ Servlet)
@RequestMapping("/user/*")//user로 시작하는 모든 요소를 처리하겠다고 지정
public class UserController {
	@Autowired
	private UserService userService;

	//스프링 프레임워크  4.3 버전 이후부터 GetMapping, PostMapping이 등장 
	@GetMapping("request") // GET방식으로 요청한 것 중에서 /user/가 있는 주소 중 request가 있는지를 찾는다.
//	@GetMapping("/user/request") // 생략하지 않고 사용하는 방식으로 이렇게도 사용이 가능하다.
	public String form() {
		return "user/write";
	}

	@PostMapping("request")
	public String submit(User dto, Model model) {//Request나 Response객체가 없다. 스프링은 톰캣과 같은 WAS없이도 테스트가 가능하다는 것을 의미한다.
		//Model은 JSP에 넘길 데이터를 담는 그릇 정도로 생각하면 된다.
		//getParameter을 사용하지 않아도 스프링 단에서 알아서 DTO의 setter메서드를 이용해서 input name속성값과 매칭하여 값을 삽입해 준다.
		//넘어온 값과 매칭되어야 할 DTO의 필드와 이름이 일치하지 않으면 의도한 대로 값이 삽입되지 않을 수도 있지만 예외가 발생하지는 않는다.
		//Request나 Session이 필요하다면 파라미터에 추가해주면 된다 (..., HttpSession session, HttpRequest request)
		String s = userService.message(dto);
		model.addAttribute("dto", dto);
		model.addAttribute("data", s);
		//Controller => Service => DB 접속
		return "user/result";
	}

}
