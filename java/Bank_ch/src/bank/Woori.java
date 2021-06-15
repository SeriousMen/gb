package bank;

public class Woori extends Bank {
//잔액 조회시 재산 반토막
	
	@Override
	int getBanlace() {
		this.money *= 0.5;
//		return money; 이렇게하면 위에 연산한 값을 반환하는게 아니라 필드에 있는 money의 값을 반환해서 안되는거 아님?
		//한번 해볼 것
		return super.getBanlace();
	}
}
