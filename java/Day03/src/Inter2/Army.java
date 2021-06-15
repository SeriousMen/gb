package Inter2;

public abstract class Army implements Soldier {
	//인터페이스에서 강제성을 없애줄것들을 써주자
	//Army는 Soldier를 임플리먼츠했기떄문에 솔저는 부모라고 할 수 있다. 자식이 추상이면 다 구현하지 않아도되니까 
	
	@Override
	public void salute() {
		
	}
	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}
}
