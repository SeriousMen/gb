package generic;

public class Gnr {

	public static void main(String[] args) {
//		GnrClass gnr = new GnrClass<>(); // 생성자 형성할 때 써도되고 안써도됨 . 일반 클래스를 넣으면 안되고 반드시 래퍼 클래스를 써줘야한다. 
		GnrClass <Integer>gnr = new GnrClass<>(); 
		
		System.out.println(GnrMethod.function("안녕")); //안에 들어가는 값의 자료형에 따라 정해진다. 스트링타입이니까 문자열 
	}
}

