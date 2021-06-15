package day01;

public class MainTest {
	public static void main(String[] args) {
		//무조건 중괄호가 열리면 선언이다. --> 메인메서드는 선언이다.
		//중괄호가 없으면 사용이다.
		if(args.length == 0) {
			System.out.println("none");
		}else {
			for (int i=0; i < args.length; i++) {
				System.out.println(args[i]);
			}
		}
	}
}
