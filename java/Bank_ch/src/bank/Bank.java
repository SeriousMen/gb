package bank;

public class Bank {
	
	
	 static final int KEY = 3;
	//객체 생성
	//돈
	int money;
	//예금주 
	String name;
	//계좌번호 
	String account;
	//비밀번호
	String pw;
	//핸드폰번호
	String phone;
	
//	public Bank() {	Q. Bank클래스에는 명시적 생성자가 없어서 디폴트로 기본생성자를 만들어주는데 왜 기본생성자를 생성했지?
//		// TODO Auto-generated constructor stub
//	}
	//메소드
	//입금
//나는 @을 쓰지않아보겠다
	void deposit(int money) {
		if(money<0) {throw new ArithmeticException();}
		this.money += money;
		
	}
	
	//출금
	
	boolean withdraw(int money) {	//이렇게 boolean 타입으로 참 거짓 조건을 만들어서 데이터를 가공할 수 있다.
		if(this.money - money <0) {
			return false;
		}
		this.money  -= money;
		return true;
		
		
	}
	//잔액조회
	int getBanlace() {
		return this.money; 
	}
	//암호화
	public static String encrypt(String pw) { 
		String en_pw = "";
		for(int i =0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i)*KEY); 
		}
		return en_pw;
	}
	//복호화
	public static String decrypt(String en_pw) {
		String de_pw = "";
		for(int i =0; i< en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(1) / KEY);
		}
		return de_pw;
	}
}
