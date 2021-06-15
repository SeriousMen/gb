package inter;

public class ImplTest2 extends SuperImplTest2 implements InterA {
	//같은 메소드가 있는데 모호성이 발생이 안함 부모클래스가 더 강해서 
	
	//만약 Inter A꺼를 쓰고 싶다면 ?
	
//	@Override
//	public void printName() {
//		// TODO Auto-generated method stub
//		InterA.super.printName();
//	}			
	public static void main(String[] args) {
		new ImplTest2().printName();
	}

	
}
