package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {

	public static void main(String[] args) {
		
		BreadMaker maker = new BreadMaker();
		BreadPlate plate = BreadPlate.getInstance(); //생성자를 만들 수 없음, getIntance()를 통해 접근 
		Thread makerThread = new Thread(maker);
		String [] menu = {"빵먹기","나가기"};
		
		//사이즈 조정 : Image 
		ImageIcon icon = new ImageIcon("src/img/main.gif");
		makerThread.start(); //쓰레드 시작
		
		while(true) {
//		JOptionPane.showInputDialog("");
		int choice = JOptionPane.showOptionDialog(null, "", "빵집", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, menu, null);
	
		if(choice ==1 || choice == -1) {System.exit(0);} //그냥 break;하면 안되고 System.exit(0)를 해야 완전히 종료가된다. 
		//Q.if문 조건에 음수와 양수의 기능을 제대로 모르겠음 
		plate.eatBread();
		
		}
		
	}
	
}

