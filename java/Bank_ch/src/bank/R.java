package bank;

import java.util.Scanner;

public class R {
	public static void main(String[] args) {
		int arr[] = {0,0,0};
		int t = 0;
		int d =0;
		if(true) {
			System.out.println("안녕");
		}
		System.out.println(++arr[0]);
		Scanner sc = new Scanner(System.in);
		for(int i =0 ; i<3; i++) {
			
			System.out.println("for문입니다.");
			if(t ==0) {
				System.out.println("첫번쨰 if문 출력");
					System.out.println("d를 입력해주세요");
					d=sc.nextInt();
				if(d ==0) {
					System.out.println("두번쨰 if문 출력다시 continue로 ");
					continue;
				}//if문은 반복문이 아닌 조건 문이라서 자신이 포함된 if문으로 가는게 아니라 반복문인 for으로 돌아간다.
				System.out.println("d는 0이 아닙니다. ");break;
			}
			
		}
	
	}
}
