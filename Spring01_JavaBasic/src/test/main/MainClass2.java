package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass2 {
	public static void main(String[] args) {
		//init.xml 문서를 로딩해서 Spring이 생성할 객체는 생성해서 관리하게 하기
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");
		/*
		 * Spring이 관리하는 객체 중에 id가 myWeapon인 객체의 참조값을
		 * Object type으로 리턴받아서 
		 * Weapon 인터페이스 type으로 casting 해서
		 * w라는 이름의 지역 변수에 참조값을 담기
		 */
		Weapon w=(Weapon)context.getBean("myWeapon");
		//메소드 호출해서 원하는 목적 달성하기
		w.attack();
	}
}
