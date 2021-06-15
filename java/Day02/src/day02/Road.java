package day02;

public class Road {
//	null은 아직 어떤 주소값을 할당할지 모를 때 쓰는 주소 초기값이다 그래서 배열도 null로 초기화
//	String data = " ";
//	String data1 = null;//null은 주소값을 뭘 넣을지 모를 떄 초기화 되는 값 	
//	data1 = "10"; //대입을 할꺼면 null로 초기화 
//	data1 += "안녕"; //연결을 할꺼면 " " 로 초기화
	public static void main(String[] args) {
		// 생성자 활용 예시
//		Car myCar = new Car();//기본 생성자가 있기 때문에 따로 Car클래스에서 명시하지않아도 생성가능 
//		Car dadyCar = new Car();
		
//		myCar.brand = "벤틀리";
//		myCar.color = "white";
//		myCar.price = 30000;	
//		dadyCar.brand = "벤츠"; 초기화할때마다 이런식으로 쓰기너무 비효율적이다.
		
//		Car myCar = new Car("벤틀리", "white", 30000);
//		Car dadyCar = new Car("벤츠","black", 15000); //이전보다 훨씬 편해짐
//		Car momCar = new Car("yellow",10000);//다형성으로 인한 생성자를 통해 초기화 
		
		//오버라이드 출력 예시 
//		SuperCar ferrari = new SuperCar(); //자식 생성자는 본인이 실행되기전에 항상 부모필드를 메모리에 올려주어야한다.
//		ferrari.brand = "FERRARI";
//		ferrari.color = "RED";
//		ferrari.price = 30000;
//		
//		ferrari.engineStart();
//		ferrari.engineStop();
		
		
		//casting
		Car matiz = new Car(); //부모 객체 생성
		SuperCar ferrari = new SuperCar(); // 자식 객체 생성 
		
		//up casting
		Car noOptionFerrari = new SuperCar(); 
		
//		SuperCar brekenFerrri = (SuperCar)new Car(); 다운캐스팅이 형변환이라고 이렇게 형변환하면 안됨 오류임		
		//다운 캐스팅 -->반드시 형변환을 해야한다.//이렇게 업캐스팅한 것을 풀어줘야한다.
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari; // 자식타입의 필드를 쓰고 싶어서 자식타입으로 풀어준다. 
		
		System.out.println(matiz instanceof Car);//참:내가 부모니까
		System.out.println(matiz instanceof SuperCar);//거짓 :부모가 자식타입은 아니니까  
		System.out.println(ferrari instanceof Car);//참:자식은 부모타입이니까
		System.out.println(ferrari instanceof SuperCar);//참: 내가 자식이니까
	
		System.out.println(noOptionFerrari instanceof Car);//참 :내가 부모니까
		System.out.println(noOptionFerrari instanceof SuperCar);//참 : 업캐스팅으로 을 부모타입에 담았으니 
		
		System.out.println(fullOptionFerrari instanceof Car);//참:자식은 부모타입이니까
		System.out.println(fullOptionFerrari instanceof SuperCar);//참:내가 자식이니까 
	}
}
