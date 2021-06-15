package atm;

public class ATM implements Runnable {

		
	int money=10000;
	
	
	@Override
	public synchronized void run() { // run에 synchronize하면 단일 쓰레드처럼됨 하나의 쓰레드가 다하고 그다음 쓰레드가 
		for(int i = 0; i <5; i++) {
			synchronized(this) { //해결책 2.하나에 블럭에 동기화 (동기화 블럭)
				withdraw(1000); //5번의 절차를 걸쳐서 1000원씩 출금을 해라 쓰레드를 기준으로 작업을 분할하는 것이아닌 하나의 메소드를 실행할때 기다려라 
			}
			try {
				Thread.sleep(500); //쓰레드는 0.5초간 멈춘다. 
			} catch (InterruptedException e) {
				
			}}
		
	}
	
	public /*synchronized */void withdraw(int money) {//해결책1.run말고 행위메소드에 동기화키워드
		this.money -= money;	//생성 시점에서 쓰레드의 이름을 받기위해서 getName()
		System.out.println(Thread.currentThread().getName() + "이(가)"+money+"원 출금"); 
		System.out.println("현재 잔액 "+ this.money + "원");
	}
}
