package com.sp.test3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("test3.userController")
public class UserController {
	@RequestMapping(value="/test3/request", method=RequestMethod.GET)
	public String form() {
		return "test3/write";
	}
	
	@RequestMapping(value="/test3/request", method=RequestMethod.POST)
	public String submit(User dto, RedirectAttributes rattr) {
		System.out.println("dto를 DB에 저장하고 있습니다..." + dto.getName());//DB작업...... blah blah
//		model.addAttribute("dto", dto);
		//리다이렉트된 페이지에 남길 값
		//F5를 눌러 새로고침하면 값이 사라진다.
		rattr.addFlashAttribute("dto",dto);
		rattr.addFlashAttribute("msg","end...");
		return "redirect:/test3/show";
	}
	
	@RequestMapping("/test3/show")
	public String view(@ModelAttribute("dto") User dto) {
		//리다이렉트 전 페이지의 값을 이곳에서 넘겨 받는 방법.
		//메서드의 인수에 @ModelAttribute 어노테이션을 사용.
		//but 새로고침 시 전달받은 값의 내용은 휘발된다.(null)
		//내부적으로는 세션으로 구현되어 있음.
		System.out.println(dto.getName() + "... flashAttribute 테스트 중");
		return "test3/view";
	}
}
