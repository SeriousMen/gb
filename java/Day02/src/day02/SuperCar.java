package day02;

public class SuperCar extends Car {
	String mode;
	
	public SuperCar() {
		super(); //부모생성자를 호출하는 것 
		//자식 생성자가 메모리에 올라가기 전에 부모의 메모리가 먼저 올라가야한다. 
		//그래서 super(); 는 항상 생성자 내 가장 위에 있어야한다.
		//따로 명시하지 않아도 자동으로 입력된걸로 친다. 따라서 super();가 없어도 됨 다만 '생성자'에서 명시를 할꺼면 제일 위에다가 해줘야한다.		
	}	
	@Override
	void engineStart() {
		
		System.out.println("음성으로 시동 킴");
		super.engineStart(); // 이렇게 하면 음성으로도 시동을 키고 부모 메소드에 선언된 열쇠로도 시동 킴이 나온다. 
		//자식에서 재정의된 소스코드로 바뀌기 전에 부모의 메소드를 호출하면 효율적으로 재정의를 구현할 수 있게 된다.
		//String data = "안녕" // 부모 
		//data += "하세요" //자식에서 부모의 기능을 그대로 유지한 후 추가한다. 
		//이걸 호출하면 부모에게 접근하는 거니까 부모의 필드도 호출해준다. -->즉 오버라이딩 + 부모의 필드 	
	}
	@Override
	void engineStop() {
		System.out.println("음성으로 시동 끔");
	}	
	//SuperCar만의 메소드를 선언 
	void openRoof() {
		System.out.println("뚜껑 열림");
	}
	void closeRoof() {
		System.out.println("뚜껑 닫힘");
		
	}	
	
}
