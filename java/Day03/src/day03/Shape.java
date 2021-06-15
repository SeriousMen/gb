package day03;

public abstract class Shape {

	
	public double area;
	public Shape() {} //기본 생성자 생성 
	
	//추상클래스안에서 추상메소드를 선언할 때 abstract를 써줘야한다.
	public abstract double getArea(double w, double h); //바디가 없다
	
	//메소드는 저장 공간이다.
	//메소드 안에 있는 코드의 주소값을 다른 곳에서 변경하지 못하도록
	//final키워드를 작성해준다.
	// 이를 final 메소드라고 한다.
	
	public final String getIntro() { //final을 썼기때문에 자식에서 재정의할 수 없다,
		return "도형입니다.";
	}
	
}
