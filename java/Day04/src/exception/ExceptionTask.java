package exception;

import java.util.Arrays;
import java.util.Scanner;

public class ExceptionTask {

	public static void main(String[] args) {
//		try {
//			System.out.println(10/0);// --> 절대 if문으로 막을 수 없음 컴파일오류가 아닌 빌드오류라서 그래서 트라이캐치로 잡아줘야한다.
//		} catch (ArithmeticException e) {
////			System.out.println(e);
//			System.out.println("0으로 나눌 수 없습니다.");
//		}
		
		
		//여러번 정수를 입력할 수 있으나 
		//5개의 정수만 입력하는 프로그램
		//q를 입력하면 나가기
		Scanner sc = new Scanner(System.in);
		int []arData = new int[5];
		int idx = 0; 
		String temp = null;
		while(true) {
			
			System.out.println(++idx +"번쨰 정수 입력[q:나가기]");
			//사용자가 입력받은 값을 임시 저장소에 담는다.
			temp = sc.next(); // q가있으니까 in말고 next
			
			if(temp.equals("q")) {break;}
			
			try {
				//예외가 발생할 수 있는 문장을 작성한다.
				arData[idx - 1] = Integer.parseInt(temp); // 배열의 인덱스니까 idx -1 temp에 담긴 String타입을 int로 해서 담기
			} catch (NumberFormatException e) {//근데 정수가 안들어오면 예외가 발생할 가능성이 있음 
				//temp는 q도아니고 정수도 아닌 값이 들어있을 때 오는 영역 
				System.out.println("정수 또는 \'q\'만 입력해주세요.");
				//idx를 복구 시킨다. //try~catch문에서 예외가 발생하면 해당하는 예외 명이 있는 catch문을 실행하고 try~catch문을 벗어나 다음 문장을 실행
				idx--; // while문안이므로 다시 입력을 받는다.
			}catch (ArrayIndexOutOfBoundsException e) {
				//입력한 정수가 5개를 초과했을 때 들어오는 영역
				System.out.println("더이상 정수를 입력하실 수 없습니다.");
				System.out.println(Arrays.toString(arData)); //배열의 내용을 출력해주는 Arrays.toString
				// 더 이상의 반복은 무의미하므로 바로 종료해준다. 
				break;
			}
			
		}
		
		
	
	}
}
