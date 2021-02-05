package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * Aspect: 공통 관심사 (횡단 관심사)
 * 
 * - 핵심 비즈니스 로직과는 상관 없는 공통 관심사를 따로 작성한다
 */
@Aspect //aspect 역할을 할 수 있도록 필요한 어노테이션
@Component //component scan을 통해서 bean이 될 수 있도록
public class WritingAspect { //aspectj expression
	@Before("execution(void write*())")
	public void prepare() {
		System.out.println("pen을 준비해요");
	}
	@After("execution(void write*())")
	public void finish() {
		System.out.println("pen을 정리해요");
	}
	
	@Around("execution(void sendEmail(java.lang.String))")
	public void emailConcern(ProceedingJoinPoint joinPoint) throws Throwable {
		//aspect가 적용된 메소드가 수행되기 이전에 작업할 내용
		System.out.println("웹브라우저를 실행해요");
		//aspect가 적용된 메소드 호출해서 수행하기
		joinPoint.proceed();
		//aspect가 적용된 메소드가 리턴된 직후 작업할 내용
		System.out.println("웹브라우저를 종료해요");
	}
	
	@Around("execution(void sendGreet(String))")
	public void greetConcern(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		 * 메소드에 전달되는인자의 갯수는 1개
		 * 메소드에 전달되는 인자의 type은 String
		 * joinPoint.getArgs()는 Object[] type을 리턴한다
		 * Object[]의 0번방에 전달된 인자가 Object type으로 들어있다
		 */
		Object[] args=joinPoint.getArgs();
		//인자로 전달된 String type의 참조값 얻어내기
		String greet=(String)args[0];
		System.out.println("greet: "+greet);
		joinPoint.proceed();
	}
}
