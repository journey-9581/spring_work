package test.auto;

public class Car {
	//필드
	private Engine engine;
	//생성자
	public Car(Engine engine) {
		this.engine=engine; //디폴트 생성자가 있지 않기 때문에 생성자에 무조건 engine을 전달해야지만 객체가 생성
	}
	//메소드
	public void drive() {
		if(engine==null) {
			System.out.println("Engine 객체가 없어서 달릴 수 없어요");
		}else {
			System.out.println("달려요");
		}
	}
}