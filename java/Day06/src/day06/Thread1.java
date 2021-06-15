package day06;

public class Thread1 extends Thread {//쓰레드 클래스를 상속(첫번째 방법) 
	private String data;
	
	public Thread1() {;} // 바디안에 ; 만있으면 일부러 비워둔 것이라는 표시 

	public Thread1(String data) {
		super();
		this.data = data;
	}
	
	@Override
	public void run() {
		for(int i =0; i<50; i++) { //넘겨받은 데이터를 10번에 걸쳐서 출력해라 
			System.out.println(data);
			try {
				sleep(500);
			} catch (InterruptedException e) {;} //밀리초로 500이니 0.5초 밀리초는 1000분의 1초 
		}
	}
}
