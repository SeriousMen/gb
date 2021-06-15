package access;

import day03.Access1;


public class Access3 extends Access1 {
	
	public static void main(String[] args) {
		Access1 a1 =new Access1();
//		a1.  프로텍티드랑 디폴트 사용 불가 
		Access3 a3 = new Access3();
//		a3. 상속받으니까 프로텍트는 나옴
		
	}
}
