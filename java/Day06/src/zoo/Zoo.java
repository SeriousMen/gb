package zoo;

public class Zoo {
	/*
	 * [실습]
동물원에 동물 3마리가 있다. 
각 동물은 울음소리가 다르고 2마리의 동물은 동시에 운다.
나머지 1마리 동물은 2마리 동물이 모두 울고 나서 마지막에 운다.
클래스는 총 2개를 사용하고 하나의 클래스에는 main메소드가 있다.
Runnable 인터페이스로 멀티쓰레드를 구현하고 반드시 join()을 사용한다.
※각 동물은 10번씩만 운다. 제한시간 : 15분
	 */
   public static void main(String[] args) {
      Animal lion = new Animal("어흥");
      Animal duck = new Animal("꽥꽥");
      Animal cat = new Animal("야옹");
      
      Thread lionThread = new Thread(lion);
      Thread duckThread = new Thread(duck);
      Thread catThread = new Thread(cat);
      
      lionThread.start();
      duckThread.start();
      
      try {
         lionThread.join();
         duckThread.join();
      } catch (InterruptedException e) {;}
      
      catThread.start(); //조인이후에 실행해야함. 메인쓰레드안에서 멀티쓰레드 구현하느라 
   }
}

















