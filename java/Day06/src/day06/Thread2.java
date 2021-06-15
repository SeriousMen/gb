package day06;
//멀티쓰레드를 구현하기위해서 동일한 쓰레드(Thread1, Thread2)를 생성한다. 
public class Thread2 implements Runnable {//Runnable인터페이스를 임플리먼츠(두번쨰 방법)
	
	private String data; 
	
	public Thread2() {;}
	
	
	public Thread2(String data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		for(int i=0; i<50; i++) {
			System.out.println(data);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {;}
		}
	}
	
}
