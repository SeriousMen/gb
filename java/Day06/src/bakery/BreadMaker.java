package bakery;

public class BreadMaker implements Runnable {

	BreadPlate plate = BreadPlate.getInstance(); //싱글톤 패턴 
	// BreadPlate 타입의 plate라는 변수에  getInstance의 리턴 값을 담는다. 
	//이 plate는 BreadPlate내부에 선언된 private static plate랑 상관이 없는 것 
		
	public BreadMaker(){;}
	

	@Override
	public void run() {
	for(int i=0; i<20; i++) {		
		plate.makeBreak(); //
		
		try {
			Thread.sleep(1000); // 1초에 하나씩 만든다.
		} catch (InterruptedException e) {
		}
	}
	System.out.println("재료 소진"); //빵을 20번 만들면 재료 소진 
	}
}
