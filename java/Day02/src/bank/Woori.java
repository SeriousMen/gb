package bank;

public class Woori extends Bank{
	
	public Woori() {}
	
	//잔액 조회 시 재산 반토막
	@Override
	int getBalance() {
		this.money *= 0.5;
		return super.getBalance();
	}
}
