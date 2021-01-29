package com.gura.spring05.cafe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.cafe.service.CafeService;

@Controller
public class CafeController {
	//의존객체 DI
	@Autowired
	private CafeService service;

	//카페 새 글 저장 요청 처리
	@RequestMapping(value = "/cafe/private/insert", method = RequestMethod.POST)
	public String insert(CafeDto dto, HttpSession session) {
		//글작성자는 세션에서 얻어내서
		String id=(String)session.getAttribute("id");
		//dto 에 담는다 
		dto.setWriter(id);
		//서비스를 통해서 새 글을 DB 에저장
		service.saveContent(dto);
		return "cafe/private/insert";
	}

	//카페 새 글쓰기 요청 처리
	@RequestMapping("/cafe/private/insertform")
	public String insertform() {
		// /WEB-INF/views/cafe/private/insertform.jsp 
		return "cafe/private/insertform";
	}
}