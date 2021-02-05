package test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.WritingUtil;

public class MainClass3 {
	public static void main(String[] args) {
		//init.xml 문서를 로딩한다 (spring bean container를 만든다)
		ApplicationContext context=new ClassPathXmlApplicationContext("test/aop/init.xml");
		//spring bean container에서 WritingUtil type의 참조값 얻어오기
		WritingUtil util=context.getBean(WritingUtil.class);
		
		util.sendGreet("안녕하세요");
		
		System.out.println("main 메소드가 종료되었습니다");
	}
}
