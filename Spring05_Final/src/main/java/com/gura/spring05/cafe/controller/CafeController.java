package com.gura.spring05.cafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CafeController {
	
	//카페 새 글쓰기 요청 처리
	@RequestMapping("/cafe/private/insertform")
	public String insertform() {
		
		// /WEB-INF/view/cafe/private/insertform.jsp
		return "cafe/private/insertform";
	}
}
