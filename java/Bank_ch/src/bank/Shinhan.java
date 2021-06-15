package bank;

public class Shinhan extends Bank {
	//출금 시 수수료 50%
	
	@Override
	boolean withdraw(int money) {
		
//		money += money*0.5; 
		money*=1.5;
		return super.withdraw(money);
	}
	
}
