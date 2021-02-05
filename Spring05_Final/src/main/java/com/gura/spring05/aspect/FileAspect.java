package com.gura.spring05.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gura.spring05.exception.NotAllowException;
import com.gura.spring05.file.dao.FileDao;
import com.gura.spring05.file.dto.FileDto;

@Aspect
@Component
public class FileAspect {
	@Autowired
	private FileDao dao;
	/*
	 * com.gura.spring05.file.servie 패키지에 있는
	 * 모든 클래스 중에 delete로 시작하는 모든 메소드에 적용할 aspect
	 */
	@Around("execution(void com.gura.spring05.file.service.*.delete*(..))")
	public void checkDelete(ProceedingJoinPoint joinPoint) throws Throwable {
		//필요한 값을 담을 지역변수 미리 만들기(메소드에 전달된 인자로부터 찾아야 한다)
		int num=0;
		HttpServletRequest request=null;
		
		Object[] args=joinPoint.getArgs();
		//반복문 돌면서
		for(Object tmp:args) {
			//필요한 type을 찾아서 casting 한다
			if(tmp instanceof Integer) {
				//자료실 파일 번호
				num=(Integer)tmp;
			}else if(tmp instanceof HttpServletRequest) {
				//HttpSession을 얻어낼 HttpServletRequest 객체
				request=(HttpServletRequest)tmp;
			}
		}
		//파일 번호를 이용해서 파일 정보를 얻어온다
		FileDto dto=dao.getData(num);
		//로그인 된 아이디
		String id=(String)request.getSession().getAttribute("id");
		//만일 로그인 된 아이디와 파일 작성자가 다르다면
		if(!id.equals(dto.getWriter())) {
			throw new NotAllowException("남의 파일을 지울 수 없습니다");
		}
		joinPoint.proceed();
	}
}
