package user;

public class Form {

	public static void main(String[] args) {
		UserField uf = new UserField();
		User user = new User();
		String msg = null;
		
		user.id = "hds1234";
		user.pw = "4321";
		
		msg = uf.join(user) ? "회원가입 성공" : "회원가입 실패"; // msg가 두개니까 삼항연산자 이용 
		System.out.println(msg);
		msg = uf.join(user) ? "회원가입 성공" : "회원가입 실패"; // 두번쨰는 회원가입 실패 중복되니까 
		System.out.println(msg);
//		if(uf.join(user)) {
//			System.out.println("회원가입성공");
//		}else {
//			System.out.println("회원가입실패");
//		}
		//오히려 true , false가 필요한 건 성공 실패 두가지 경우의 수 밖에 없는 로그인, 회원가입 등등 .. 이럴떄 boolean타입의 메소드를 활용 
		
		msg = uf.login("hds1234", "4321") ? "로그인 성공" : "로그인실패";
		System.out.println(msg);
	}
}
