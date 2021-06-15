package Inter2;
//병장
public class Sergeant  extends Army {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}
//병장은 솔저라는 인터페이스의 메소드에 포함안되는게 생긴다. 그래서 다이렉트로 인터페이스를 임플리먼츠를 하면안되고 중간에 추상클래스를 거쳐야한다. 
	//추상클래스에서 강제성이 사라진다. 그래서 인터페이스 - 추상클래스 -클래스 
	
	
	
}
