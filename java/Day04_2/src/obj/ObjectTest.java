package obj;

import java.util.Random;

public class ObjectTest {
	public static void main(String[] args) {
		
		/**
		 * String Constant Pool: 직역하자만 문자열 상수 풀 , 즉 자바에서 String은 리터럴로 선언 시에 heap메모리안에 String pool이라는 영역에  메모리가 올라가고 
		 * 만약 동일한 값을 사용하려고하면 해당 String Pool에 저장된 주소의 값을 반환하고 없으면 String pool안에 새롭게 생성이 된다.(String타입의 특징인 -불변성의 활용) 
		 * 이것은 literal으로 생성했을 때 이야기며 만약 new 연산자로 생성을 하면 새로운 객체가 생성이 되는 것이기 때문에 String pool이 아닌 
		 * 외부에 해당 객체가 생성이 된다. 이는 메모리 사용면에서 상당히 비효율적이며 그렇기 때문에 String을 선언할 때는 new 연산자로 할당하는 것이 아닌 literal(" ")을 이용해서 생성하는 것이
		 * 권유된다. 만약 String 클래스의 equals 메소드로 값을 비교하는게 아닌 == 로 주소값을 비교하면 당연히 String Pool 밖에 있는 값들은 false가 나온다.
		 * 이떄 String 클래스의 intern()을 통해 해당 값을 스트링 풀에 등록한다.. 만약 이미 존재할 경우에는 스트링 풀에 해당 문자열의 주소를 반환한다. 
		 * 즉, intern()은 리터럴로 스트링을 선언했을 때 기능을 new String이 하도록 해주는 것이다.
		 * 
		 */
		String data1 = "ABC";
		String data2 = "ABC";
		String data3 = new String("ABC");
		String data4 = new String("ABC");
		
		System.out.println(data1 == data2); // true 주소를 비교 , 새롭게 생성자를 통해 주소를 할당하는게 아니라서 같은 값을 가져다가 쓴다. 
		System.out.println("====어떻게 컨스턴트 풀의 주소를 가져오는가?===");
		System.out.println(data3 == data4); // false 주소를 비교, 새롭게 생성자를 통해 만들었기때문에 다른 주소가 생성된다. 
		System.out.println(data3.intern()==data4.intern()); // true intern()을 통해 둘다 String pool안에 있는 값을 반환
		System.out.println(data1 == data3.intern());//true data3은 data1의 ABC를 반환
		System.out.println(data3 == data1.intern());//false 이건 그냥 data1 == data3과 다를바 없지 

		
		System.out.println("======================");
		System.out.println(data3.equals(data4)); // true equals의 내용을 보면 data3과 data4가 스트링 타입이라서 String 클래스의 equals다.
		
		//그리고 String클래스의 equals는 값을 비교할 수 있도록 재정의 한것이다. 
		System.out.println("========================");
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode()); //둘은 같은 주소값을 가짐, 너무당연함 같은 값이니까 하나의 주소에 있는 값을 참조 
		System.out.println("========================");
		System.out.println(data3.hashCode()); 
		System.out.println(data4.hashCode());	//근데 이것도 같다..? 왜냐면 이것도 String의 hashCode, 똑같이 값이 같으면 주소도 값게 재정의(override)함
		System.out.println("========================");
		
		
		Random r1 = new Random();
		Random r2 = new Random();
	
		System.out.println(r1 == r2);// false이렇게만하면 다른 객체니까 당연히 주소값이다름
		r1 = r2; //객체 = 객체를 하면 값이 담기는게 아니라 r2에있는 주소값이 r1에 대입되는거다. 그래서 주소값과 함꼐 값도 따라온다. 
		System.out.println(r1.equals(r2)); //true
		
		
		
	
	}
}
