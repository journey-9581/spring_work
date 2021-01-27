package com.gura.spring05.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		return "users/signup_form";
	}
	
	//ajax 요청 처리
	@RequestMapping("/users/checkid")
	public ModelAndView checkid(@RequestParam String inputId, ModelAndView mView) {
		/*
		 * @RequestParam String inputId는
		 * String inputId=request.getParameter("inputId")와 같다
		 */
		//서비스를 이용해서 해당 아이디가 존재하는지 여부를 알아낸다
		boolean isExist=service.isExistId(inputId);
		//ModelAndView 객체에 해당 정보를 담고 view page로 forward 이동해서 응답
		mView.addObject("isExist", isExist);
		mView.setViewName("users/checkid");
		return mView;
	}
}