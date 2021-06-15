package bakery;

public class BreadPlate {
	int breadCnt;
	int eatCnt;
	//static은 메모리에 가장 먼저 할당되고, 그 이후로 재할당되지않는다. 
	private static BreadPlate plate; //private static으로 getIntance메소드를 통해서만 접근할 수 있고 정보를 고유하게 유지하기위해 
	
	private BreadPlate() {;}//객체 생성 못하게 private으로 막아놓는다.--> getInstance로만 접근 가능하게 
	
	public static BreadPlate getInstance() { //getInstance()를 통해서만 BreadPlate의 접근해서 구현된 메소드에 의해 필드 접근 
		//이미 값을 가지고 있다면(빵이 있다면) 
		if(plate != null) {
			//그대로 리턴 (빵의 수 반환)
			return plate;
		}
		//값을 가지고 있지 않다면 new를 사용해서 할당한다.
		
		//static이 붙어 있기 떄문에 재할당되지 않는다.--> 기존의 정보가 리셋되지않는다. 새로운 객체가 메모리에 할당이 되지않는다.
		plate = new BreadPlate();// 자기 클래스 내부에서니까 객체생성성가능 
		//private static BreadPlate plate = new BreadPlate();와 같은 거다. 
		//이 메소드를 통해 어떤 특정 조건일 때 객체를 생성할 수 있도록하고
		// static 타입으로 선언이 됬기떄문에 메모리에 추가 생성을 안하고. breadCnt와 eatCnt의 변한 값을 업데이트해준다.
		return plate;
	}
	
	
	public synchronized void makeBreak(){
		if(breadCnt >9) {
			System.out.println("빵이 가득 찼습니다.");
			
			try {
				wait(); //갖고 있던 고유 락(syncronized)을 해제하고 스레드를 잠들게 한다.
			} catch (InterruptedException e) {;}
		}// 여기서 멈추게해줄 것 
		//가득차지 않았다면 
		breadCnt++;
		System.out.println("빵을 1개 만들었습니다. 총: "+ breadCnt +"개");
	}
	
	
	public synchronized void eatBread() {
		if(eatCnt == 20) { // 최대로 먹을 수 있는 횟수는 20번이다. 
			System.out.println("빵이 다 떨어졌습니다.");
			
		}else if(breadCnt<1) { //빵이 없으면 만든다.
			System.out.println("빵이 없습니다. 만들 때 까지 기다려주세요.");
			
		}else {
			breadCnt --;
			eatCnt ++;
			System.out.println("빵을 1개 먹었습니다. 총:"+ breadCnt + "개");
			
			this.notify(); //notify()는 잠들어 있던 스레드 중 '임의로' 하나를 골라서 꺠우는 것 
			// notifyAll()은 교착 상태일때 쓰는 것 --> 잠들어 있던 스레드 모두 꺠우는 것 
		}
		
	}
}
