package com.gura.spring01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//최상위 경로 요청이 오면
	@RequestMapping("/home.do") //.do는 생략 가능
	public String home() {
		
		//WEB-INF/views/home.jsp 페이지로 forward 이동해서 응답하기
		return "home";
	}
}
