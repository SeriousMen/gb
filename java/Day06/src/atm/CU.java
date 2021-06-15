package atm;

public class CU {
	public static void main(String[] args) {
		ATM atm = new ATM();
		
		Thread mom = new Thread(atm,"엄마"); // 생성시점에 쓰레드에게 이름을 부여 
		Thread son = new Thread(atm,"아들"); // 2개의 객체가 5번씩 출금을 하니까 결국 0원이 되어야함 

		mom.start();
		son.start();
	}
}
