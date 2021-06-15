package day06;

public class ThreadTest {

	public static void main(String[] args) {
//		Runnable t1 = new Thread2("?"); // Thread2 를 Runnable 타입으로 담았으니 업캐스팅
//		Thread2 t2 = new Thread2("!");				
//		//start()메소드로 스케줄링하기 위해서 Thread타입 객체가 필요하다.
//		//Thread 생성자에 run메소드가 재정의된  객체를 전달해주면 
//		//스케줄링 시 해당 run메소드가 자원으로 할당된다. 		
//		//Runnable을 implements 받아서 Thread를 만들때는 start()를 사용해야 하기 때문에 Thread() 생성자의 매개값으로 넘겨줘야한다
//		 //멀티쓰레드
//		Thread thread1 = new Thread(t1);
//		
//		Thread thread2 = new Thread(t2); //여기도 t1이면 자원의 공유 
////		Thread thread2 = new Thread(new Thread2()); //이렇게 러너블 객체의 생성과 쓰레드타입으로의 변환을 한번에 할 수 도 있다.
//		thread1.start();
//		thread2.start();
		
		
		
		// ㅁ한자8 
		//윈도우+마침표 
		Thread1 t1 = new Thread1("★");
		Thread1 t2 = new Thread1("♥");
		//자원은 run메소드 안에 있는 것 
		//쓰레드의 우선순위 
		t2.setPriority(10);
		System.out.println("t1의 우선순위:" + t1.getPriority());
		System.out.println("t2의 우선순위:" + t2.getPriority());
		
		t1.start();
		t2.start();
//		t1.run(); //이렇게 그냥하면 단일 쓰레드 .. 원래 하나의 메소드가 끝나고 다음 메소드가 실행되니 
//		t2.run();
//		
//		
//		
//		t1.start(); // 멀티 쓰레드
//		t2.start();
//	
	
		
		
//		try {
//			//먼저 실행되어야할 쓰레드에 join()메소드를 사용하면 다른 쓰레드는 전부 대기 상태로 전환되며, 해당 쓰레드가 모두 종료되어야 다른 쓰레드가 실행된다.
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			
//		}
//		System.out.println("메인쓰레드 종료"); 
		
		
		
	}
}
