package day02;

public class Car {
	String brand;
	String color;
	int price;	
	/*기본 생성자 
	 * 클래스 선언시 자동으로 기본 생성자가 생성된다.
	 * 만약 사용자가 직접 기본생성를 선언한다면 
	 * 선언한 생성자가 기본생성자로 설저된다.
	 * */	
	public Car() {
		
	}
				
	public Car(String color, int price) {
		//같은 이름이라도 매개변수가 달라서 만들 수  있다. -> 오버로딩
		this.color = color;
		this.price = price;
	}
	
	//alt + shift +s + o 명시적 생성자 생성 단축키 
	public Car(String brand, String color, int price) {
		
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	void engineStart() {
		System.out.println("열쇠로 시동 킴");
	}
	void engineStop() {
		System.out.println("열쇠로 시동 끔");
	}
}
