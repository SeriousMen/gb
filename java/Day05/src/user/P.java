package user;

public class P {

	public static void main(String[] args) {
		boolean a = false;
		
//		if(a) {
//			System.out.println("false 입니다.");
//		}else if(true) System.out.println("false 안나온다");
//		else System.out.println("?");
		
		P.method();
		
	}
	
	
	static boolean method() {
		if(false) {
			System.out.println("false 출력");
			return false;
		}
		System.out.println("true");
		return true;
	}
}
