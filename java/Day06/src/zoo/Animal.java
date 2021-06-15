package zoo;

public class Animal implements Runnable{
   
   private String sound;
   
   public Animal() {;}//그냥 계속 만들어줄것 객체생성할때도 필요하니 
   
   public Animal(String sound) {
      super();
      this.sound = sound;
   }

   public void makeSound() {
      System.out.println(sound);
   }
   
   @Override
   public void run() {
      for (int i = 0; i < 10; i++) {
         makeSound();//메소드안에 메소드 사용 
         try {   Thread.sleep(500);} // 0.5초씩 쉬면서 울어 
         catch (InterruptedException e) {;}
      }
   }
}






