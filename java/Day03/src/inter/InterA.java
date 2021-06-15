package inter;

public interface InterA {
	
	int data = 10; // final 생략된 것 final static or static fianl 다 똑같음  :상수선언
	
//	void getData();// abstract 생략된 것 
	
	
	
	default void printName() {// 일반 메소드 쓰려면 default 
		System.out.println("한동석 InterA");
	}
}
