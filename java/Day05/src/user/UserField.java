package user;

import java.util.ArrayList;

public class UserField {
	//ArrayList를 내부 저장소로 구현 
	//회원의 정보는 아이디,비밀번호 2개이다.
	
	//배열은 크기를 제한할 때 사용하고 ArrayList는 몇 개의 데이터가 들어올지 알수 없을 때 사용한다. 
	ArrayList<User> users = new ArrayList<>(); //User라는 클래스를 만들고 매개변수로 클래스타입을 넣었다 -> 좋은 방법인듯 
	final int key =3;
	//아이디 중복검사
//	boolean idChecker(String id) {
//		if(users.contains(id)) {
//			return false;
//		}
//		return true;
//	}	//이렇게 중복검사에서 boolean타입해서 삼항연산자를 통해 할 수 도 있긴함 정답은 없음 뭐가 더 효울적인가의 문제 
	
	//선생님 ver -- boolean타입으로 안하고 이렇게한 이유? 회원가입뿐만 아니라 로그인에도 쓰려고 
	public User checkId(String id) {
		for(int i=0; i <users.size(); i++) {
			if(users.get(i).id.equals(id)) {//만약 입력받은 id와 기존에 있는 id가 동일하다면  해당 중복되는 기존의 id를 리턴해라 
				return users.get(i); // return 값이 두개일 수 는 없지만 이렇게 if문으로 return의 선택지는 2개일 수 있다.
			}
		}
		return null; //만약 중복되는게 없다면 아무것도 리턴하지마 ... 그냥 중복 검사라서 차후에 활용할 메소드지 이거 가지고 원천 해결할 것이 아님 
	}
	//회원가입
	public boolean join(User user) {
		if(checkId(user.id) == null) { //아이디가 중복이 아니라는 것 
			user.pw = encrypt(user.pw);//암호화 해주기 , 만약 아이디가 중복이 아니라면 해당 pw를 암호화해라
			users.add(user);//그리고 id와 pw를 어레이리스트에 담아라 
			return true;// 
		}
		return false;
		
	}
	
	 
	//로그인
	public boolean login(String id, String pw) {
		User user=checkId(id);
		if(user != null) {
			if(decrypt(user.pw).equals(pw)) {
				return true;}}	//if문안에 직접적으로 true , false를 넣고 false는 실행 하지않고 true인 문만 실행하는 직선적인 방법말고 
		return false; }			//이렇게 boolean메소드로 return타입을 true, false를 주면 해당 메소드를 실행한 결과를 통해 똑같이 할 수 있다.
	
	//암호화
	public String encrypt(String pw) {
		String en_pw = "";
		for(int i=0; i< pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * key);
	}
		return en_pw;
	}
	
	//복호화 
	public String decrypt(String en_pw) {
		String de_pw = "";
		for(int i=0; i <en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i)/key);
		}
		return de_pw;
	}
}
