package day02;

class A { //class A를 생성하고 필드(변수와 메소드)를 선언 
	int data1;
	double data2;//변수,필드,인스턴스변수(객체)
	
	void setData1(int data1) {
		this.data1 =data1;//외부에서 data1을 받아서 필드에 있는 data1에 집어넣으려고
		//this는 아래 a의 주소값 b객체의 주소 값을 가지고 온다.  
		//--> 왜 ? a, b라는 새로운 객체를 생성했으니까 A의 클래스의 필드를 사용하기 위해서는 그 새로운 객체의 주소값을 가져와야 담을 수 있으니까 
		System.out.println("this :" + this); // 객체를 이용한 호출 시 this가 누구의 주소 값을 가지고 있는지 출력 
	}
	
	
}

public class ClassTest1{
	public static void main(String[] args) {
		A a = new A();
		A b = new A(); // a 랑 b의 주소 값이 다르다.
		
		a.setData1(10);  
		// 하나의 응용프로그램에서는 this가 하나밖에 제공안된다. 자바는 단일 프로세스라서 동시에 작동이 안되니까.
		
		b.setData1(100);
//		
//		System.out.println(a.data1);
//		System.out.println(b.data1);

		System.out.println("a객체 : " +a); // a객체의 주소값과 메소드를 호출했을 때 this의 주소 값이 같다.
		System.out.println("b객체 : " +b);// b객체의 주소값과 메소드를 호출했을 때 this의 주소 값이 같다 
				
	}
	
}
