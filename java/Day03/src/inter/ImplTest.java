package inter;

public class ImplTest implements InterA, InterB {
	//두 인터페이스에서 같은 메소드가 선언되서 모호성 발생
//	@Override
//	public void printName() {
//		// TODO Auto-generated method stub
//		InterA.super.printName();
//	}
	
	@Override
	public void printName() {
		// TODO Auto-generated method stub
		InterB.super.printName();
	}

	
	public static void main(String[] args) {
		new ImplTest().printName();
		
	}

	
}
