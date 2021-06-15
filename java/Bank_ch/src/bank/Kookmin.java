package bank;

public class Kookmin extends Bank {
//입금시 수수료 50%
	
	@Override
	void deposit(int money) {
		money *= 0.5; //부모 클래스에서 메소드내용이 어떤지 파악해서 객체를 이해해라 
		super.deposit(money);
	}
	
}
