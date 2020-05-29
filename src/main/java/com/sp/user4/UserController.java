package com.sp.user4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("user4.userController")
public class UserController {
	//Map, Model, ModelMap
	/*//#1 Map으로 반환하기.
	@RequestMapping(value="/user4/hello")
	//Map으로 반환하면 view단에 전달할 값을 의미한다. request.setAttribute의 개념과 유사하다고 생각하면 된다.
	//Map으로 반환했을 때의 문제점: jsp의 이름을 명시할 수 없다. jsp의 이름은 RequestMapping으로 설정한 주소로 고정된다.
	public Map<String, Object> execute() throws Exception{
		Map<String, Object> model = new HashMap<>();
		model.put("result", "홍길동님 안녕하세요...");
		return model;
	}
	*/
	
	//#2 Model:인터페이스인 Model로 반환하기, #1과 마찬가지로 jsp의 이름은 RequestMapping으로 설정한 주소와 같다.
	//#3 ModelMap
	//Map과의 차이라면 제네릭이 없다.
	@RequestMapping(value="/user4/hello")
	public ModelMap execute() throws Exception{
//		Model model= new ExtendedModelMap();
		ModelMap model = new ExtendedModelMap();
//		model.addAttribute("result","model로 리턴");
		model.addAttribute("result","modelmap으로 리턴");
		return model;
	}
}
