package day04;

import java.util.Random;

public class Starbucks {
	//신규 매장의 메뉴판
	String[] arMenu;
	//신규 매장의 가격표 
	int[] arPrice;
	//신규매장 등록하기
	//Cafe는 인터페익스이기 때문에 외부에서 값을 전달 받으려면 모든 추상메소드가 구현이 되어야 한다.
	//이를 이용하여, 신규 매장이라면 반드시 cafe에 선언된 기능들을 구현해야 한다.
	//외부에서 기능이 모두 구현된 필드의 주소값이 c 객체로 전달되므로, 해당 필드에 접근하여
	//구현된 메소드를 사용해준다. 
	public void register(Cafe c) {//Cafe라는 인터페이스의 타입인 c를 매개변수로 
		arMenu = c.getMenu();	//리턴 타입이 있는 메소드가 바디가 없으니까 값이다.
		arPrice = c.getPrice();
		
		//만약 가격부분을 구현하지 않은 매장이라면 무료나눔매장 
		if(arPrice == null) {
			System.out.println("무료 나눔확인 완료");
			return;
		}
		
		System.out.println("==========확인중===========");
		for(int i=0; i< arMenu.length; i++) {//입력받은 메뉴들 다 돌려서 
			System.out.println(arMenu[i]+ ":" + arPrice[i] + "원"); 
			
		}
		System.out.println("메뉴/가격 이상없음");
		
		try {
//			c.sell(arMenu[new Random().nextInt(arMenu.length)]);
			c.sell("빵"); 
			System.out.println("판매 방식 이상없음");
		} catch (Exception e) {
			System.out.println("등록 실패, 본사에 문의해주세요");
			return;
		}
		System.out.println("정상 등록되었습니다.");
	}
}
