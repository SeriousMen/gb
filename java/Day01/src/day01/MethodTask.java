package day01;

import java.util.Scanner;

public class MethodTask {
	//1~n까지의 합을 구해주는 메소드
	
	void addMethod(int a) {
		
		int add = 0;
		
		for(int i=0 ; i< a ; i++) {
			
			
			add += i;
			
		}
		System.out.println(add);
	}
	//나눗셈
	
	void divideMethod(int a, int b) {
		
		System.out.println(a/b);
	}
	
	
	
	//선생님 ver
	//1부터n까지의 합을 println()으로 출력하는 메소드
	void printSumFrom1(int end){
		if( end <1 ) {
//			System.out.println("1보다 큰 수를 입력해주세요");
//			return;//void에서는 return이 업지만 return;만나는 순간 종료 
			throw new ArithmeticException();
		}
		int total = 0;
		for(int i=0; i<end; i++) {
			total += i+1;//<end니까 +1
		}
		System.out.println(total);
	}
	
	//나눗셈을 구해주는 메소드
	/*@
	 * 
	 * 
	 * 
	 */
	public int divFor2Integers(int num1, int num2) {
	
			return num1 / num2;
		
	}
	
	
	public static void main(String[] args) {
		MethodTask mt=new MethodTask();
		mt.addMethod(9);
		
		System.out.println("나누는 메소드");
		mt.divideMethod(10, 5);
		
		try {
			mt.printSumFrom1(-1);
		} catch (ArithmeticException e1) {
			System.out.println("0보다 큰 수를 입력해주세요");
		}
		
		try {
		mt.divFor2Integers(10, 0);
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
			
		}
	}
}
