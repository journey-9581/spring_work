package test.main4;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass {
	public static void main(String[] args) {
		//비밀번호라고 가정
		String pwd="abcd1234";
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//인코딩해서 암호화 된 문자열 얻어내기
		String result=encoder.encode(pwd);
		System.out.println(result);
	}
}
