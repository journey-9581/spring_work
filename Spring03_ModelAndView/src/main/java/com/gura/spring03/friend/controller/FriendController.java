package com.gura.spring03.friend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.friend.dto.FriendDto;

@Controller
public class FriendController {
	
	@RequestMapping("/friend/list.do")
	public String list(HttpServletRequest request) {
		//view page에 전달할 Model(data)
		List<String> list=new ArrayList<String>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		
		//request scope에 "list"라는 키값으로 Model 담기
		request.setAttribute("list", list);
		
		// /WEB-INF/views/friend/list.jsp
		return "friend/list";
	}
	
	/*
	 * ModelAndView 객체는
	 * Model(data)와 view page 정보를 동시에 담을 수 있는 객체이다
	 * ModelAndView 객체를 컨트롤러의 메소드에서 리턴해주면
	 * ModelAndView 객체에 담긴 data는 자동으로 request scope에 담기고
	 * ModelAndView 객체에 담긴 view page 정보대로 forward 이동 된다
	 */
	
	@RequestMapping("/friend/list2")
	public ModelAndView list2() {
		
		//view page에 전달할 Model(data)
		List<String> list=new ArrayList<String>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		
		//1. ModelAndView 객체를 생성해서
		ModelAndView mView=new ModelAndView();
		//2. Model(data)를 담고
		mView.addObject("list", list);
		//3. view page 정보도 담고
		mView.setViewName("friend/list");
		//4. 리턴해준다
		return mView;
	}
	
	//메소드의 인자로 ModelAndView를 선언하면 Spring이 객체를 생성해서 전달해준다
	@RequestMapping("/friend/list3")
	public ModelAndView list3(ModelAndView mView) {
		//view page에 전달할 Model(data)
		List<String> list=new ArrayList<String>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		//ModelAndView 객체를 직접 생산하지 않고 메소드의 인자로 전달 받아서 사용할수도 있다
		mView.addObject("list", list);
		mView.setViewName("friend/list");
		return mView;
	}
	
	@RequestMapping("/friend/delete")
	public String delete(HttpServletRequest request) {
		//삭제할 번호
		int num=Integer.parseInt(request.getParameter("num"));
		System.out.println(num+"번 친구의 정보를 삭제하였습니다");
		/*
		 * [리다이렉트 이동]
		 * 웹브라우저에게 새로운 경로로 요청을 다시 하라고 응답하는게 리다이렉트 이동이다
		 * 스프링에서 리다이렉트 응답을 할 때는 view page 정보를
		 * "redirect: 컨텍스트 경로를 제외한 절대경로"와 같이 작성하면 된다
		 * 
		 * ModelAndView 객체도 같다
		 * mView.setViewName("redirect: 경로");
		 */
		//친구 목록 보기로 리다이렉트 이동 시키기
		return "redirect:/friend/list.do"; //"redirect:/spring03/friend/list.do"는 틀림
	}
	
	//친구 추가 폼 요청 처리
	@RequestMapping("/friend/insertform")
	public String insertform() {
		//수행할 비즈니스 로직은 없고 단순히 view page 정보만 리턴하는 경우도 있다
		return "friend/insertform";
	}
	
	//친구 추가 요청 처리
	@RequestMapping("/friend/insert")
	public String insert(HttpServletRequest request) {
		//폼 전송되는 파라미터 추출
		int num=Integer.parseInt(request.getParameter("num"));
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		//추출된 정보 테스트로 출력해보기
		System.out.println(num+"|"+name+"|"+phone);
		//view page로 forward 이동해서 결과 응답하기
		return "friend/insert";
	}
	/*
	 * "num"이라는 파라미터 명으로 전달되는 파라미터 => @RequestParam int num
	 * "name"이라는 파라미터 명으로 전달되는 파라미터 => @RequestParam String name
	 * "phone"이라는 파라미터 명으로 전달되는 파라미터 => @RequestParam String phone
	 */
	@RequestMapping("/friend/insert2")
	public String insert(@RequestParam int num, @RequestParam String name, @RequestParam String phone) {
		//추출된 정보 테스트로 출력해보기
		System.out.println(num+"|"+name+"|"+phone);
		return "friend/insert";
	}
	
	/*
	 * 컨트롤러의 메소드에 dto를 인자로 받게 선언해놓으면
	 * 요청 파라미터가 자동 추출 되어서 dto에 저장 되어서 전달된다
	 * "num"이라는 파라미터 명으로 전달되는 파라미터 => dto의 num이라는 필드에 저장
	 * "name"이라는 파라미터 명으로 전달되는 파라미터 => dto의 name이라는 필드에 저장
	 * "phone"이라는 파라미터 명으로 전달되는 파라미터 => dto의 phone이라는 필드에 저장
	 */
	@RequestMapping("/friend/insert3")
	public String insert(@ModelAttribute FriendDto dto) {
		System.out.println(dto.getNum()+"|"+dto.getName()+"|"+dto.getPhone());
		return "friend/insert";
	}
}
