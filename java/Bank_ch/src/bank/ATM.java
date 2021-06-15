package bank;

import java.util.Random;
import java.util.Scanner;

/*/ 실슴예제 은행프로그램
 * 각 은행별로 최대 100명의 고객을 유치할 수 있다.
 * 메인메뉴 : 은행 선택(신한, 국민, 우리)
 * 사용자 메뉴 : 계좌개설, 입금하기, 출금하기, 잔액조회, 계좌번호 찾기, 돌아가기
 * 계좌 개설 시 필요한 정보
 *  1. 예금주  2. 비밀번호(비밀번호는 4자리이고, 4자리를 입력할 때 까지 무한반복)
 *  3. 계좌번호(계좌번호는 6자리이며, 100000부터 시작한다. 중복검사 후 중복이 없을 때 까지 무한반복) new Random().nextInt() 사용
 *  4. 핸드폰 번호(-를 제외하고 입력받으며, 중복검사 후 중복이 없을 때 까지 무한 반복)
 *  ※ 중복검사는 해당 은행의 고객 수 만큼만 반복하여 검사한다.
 *  핸드폰 번호와 비밀번호를 입력한 후 일치하는 고객의 계좌번호를 재발급해준다.
 *  국민은행 : 입금 시 수수료 50%
	신한은행 : 출금 시 수수료 50%
	우리은행 : 잔액 조회시 재산 반토막
 */
public class ATM {
	public static void main(String[] args) {
		
		Shinhan[] arS = new Shinhan[100];
		Kookmin[] arK = new Kookmin[100];
		Woori[] arW = new Woori[100];
		
		int[] arMemberConunt = {0,0,0};
		
		Bank[][] arrBank = {arS, arK, arW};
		
		String main_menu = "1.신한은행\n2.국민은행\n3.우리은행\n4.나가기";
		String user_menu = "1.계좌개설\n2.입금하기\n3.출금하기\n4.잔액조회\n5.계좌번호 찾기\n6.돌아가기";
		
		Scanner sc = new Scanner(System.in);
		
		int bank_choice =0;
		int user_choice =0;
		
		Random r = new Random();
		
		
		String name =null;
		String pw =null;
		String account =null;
		String phone = null;
		
		int money =0;
		boolean isDupAccount = false;
		
		Bank temp =null; // temp는 bank 타입으로 선언되서 temp. 하면 해당 필드에 접근이 가능 똑똑
		
		
		while(true) { //이 while문으로 계속 반복되게 한다.
			System.out.println(main_menu);
			bank_choice = sc.nextInt();
			
			if(bank_choice ==4) {
				break;
			}else if (bank_choice <1 || bank_choice>arMemberConunt.length) {
				continue; // 
			}
			while(true) {//4번을 누르지않는다면 다음 반복문으로 넘어간다. 
				System.out.println(user_menu);
				user_choice = sc.nextInt();
				if(user_choice ==6) {
					break; // 반복문을 나가는거니까 뒤로가기
				}
				
				switch(user_choice) {
				//switch 안에 조건에 그냥 문자열로 채워 넣을 수 도 있다. ( 이것도 값이니까)
				//case1 계좌개설
				case 1: if (arMemberConunt[bank_choice-1] == arrBank[bank_choice-1].length) {
					
					/*/
					 * 이차원 배열의 길이 arr[x][y];
					 * arr.length = x 즉, 행의 갯수
					 * arr[행]=y 즉, 즉 그 행의 열의 갯수  
					 */
					System.out.println("정원 초과입니다.");
					break; // 다시 메뉴선택 창으로
				}
				System.out.println("예금주 :");
				name =sc.next();
				
				while(true) {
					System.out.println("비밀번호(4자리) :");
					pw = sc.next(); 
					if(pw.length()==4) {
						break;
					}
				}
				while(true) {
					isDupAccount = false;
					
					account = r.nextInt(900000) +100000 + ""; //Q.왜 nextInt안에 그냥(1000000)을 넣어주지않고 더한거지?
				
					for(int i =0; i <arMemberConunt.length ; i++) {
						
						for(int j =0; j< arMemberConunt[i]; j++) {
							
							if(arrBank[i][j].account.equals(account)) {
								
								isDupAccount = true; 
								break; // 다른 은행일지라도 전체은행들중 계좌번호가 중복이 되면 안되기 떄문에 
							}
						}
						if(isDupAccount) { // 첫번 쨰 for문도 탈출하기위해서 
							break;
						}
					}//그러면 for문을 나가기 떄문에 다시 while문에 가서 계좌번호 입력을 대기하겠지? 
					if(!isDupAccount) {
						break; //계좌번호가 참이면 while문 탈출 해서 다음꺼 입력받아라
					}
				} // switch문은 해당 case 에 break를 걸어주지않는이상 아래로 계속 진행되니까 위에서 break; 하는건 
				//해당 while에서 나오는거고 순차적으로 다시 아래에 있는 코드가 진행이된다.
				while(true) {
					boolean isRightPhoneNumber = false;
					boolean isDupPhone = false;
					
					System.out.println("핸드폰 번호 :");
					phone = sc.next(); 
					
					for(int i = 0; i< phone.length(); i++) {
						char c = phone.charAt(i);
					if(c<48 ||c >57 ) {
						
						isRightPhoneNumber =true; //Q.영어상 정수가 아닌 값이 입력됬을떄니 false가 맞지만 그냥 여기선 기능 적으로 사용한듯
						break;
					}
					
					
					}
					if(isRightPhoneNumber) {
						continue; //그니까 올바른게 입력안된거면 그냥 while문 다시 반복 다시입력받아라
					}
					
					for(int i=0; i <arrBank.length; i++) {
						for(int j =0; j< arMemberConunt[i]; j++) {
							if(arrBank[i][j].phone.equals(phone)) {
							isDupPhone = true;
							break;
							
						}
					}
					if(isDupPhone) { break;}
				}
				
				if(!isDupPhone && !isRightPhoneNumber) {break;}//만약에 중복안되고 올바른 정수가 입력됬으면 while문 벗어나게 해줄게
				}
				Bank[] arNewMember = { new Shinhan(), new Kookmin(), new Woori()}; // 이안에서 쓸거라서 지역변수로 한듯 ?
				
				arrBank[bank_choice-1][arMemberConunt[bank_choice-1]]= arNewMember[bank_choice-1];
				//bank_choice 1을 입력하면 arrBank[0][arMemberConunt]이니까 
				//Shinhan[arMemberConunt의값] = new Shinhan()이 되서 새로운 고객을 은행에 추가해주는 것 (인덱스 = 길이-1)
				
				temp = arrBank[bank_choice-1][arMemberConunt[bank_choice-1]];
				//해당은행의 신규고객의 정보를 temp에 임시적으로 담아준다 .
				temp.name = name;
				temp.account = account;
				temp.pw =Bank.encrypt(pw); // 아까 암호화 메소드에 새로 입력되는 pw의 값을 입력받아서 담아준다, 
				temp.phone = phone; 
				
				System.out.println("예금주 :" + temp.name);
				System.out.println("계좌번호 :" + temp.account);
				System.out.println("암호화 :" + temp.pw);
				System.out.println("복호화 :" + temp.decrypt(pw));
				System.out.println("폰번호: " + temp.phone);
				
				if(arMemberConunt[bank_choice-1] != 0) { //만일 회원이 없지 않다면  
					temp = arrBank[bank_choice-1][arMemberConunt[bank_choice-1]-1];//해당 은행 고객정보인덱스의 -1 --> 이전회원
					System.out.println("=============이전고객=============");
					System.out.println("예금주 :" + temp.name);
					System.out.println("계좌번호 :"+ temp.account);
					System.out.println("암호화 :" + temp.pw);
					System.out.println("복호화 : "+ Bank.decrypt(temp.pw));
					System.out.println("폰번호 : "+ temp.phone);
				}
				arMemberConunt[bank_choice-1]++; //인덱스 안에 있는 값이 증가해서 회원 수가 증가
				break;
				
				//입금하기
				case 2:
					isDupAccount = false;
					
					System.out.println("계좌번호 :");
					account = sc.next(); 
					
					for(int i =0; i<arMemberConunt.length; i++) {//arMemberConunt.length은 3이니까 은행 3개
						for(int j =0; j<arMemberConunt[i]; j++) {//각은행 마다 살펴봐서 계좌가 등록됬는지 확인
							if(arrBank[i][j].account.equals(account)) {
								isDupAccount = true; //계좌가 등록되있으면 true고 true면 temp에 담고 나가라 
								temp = arrBank[i][j];//애초에 계좌없으면 여기안들어옴
								break;
							}
						} // for문 자체를 검사를 위한 것 
						if(isDupAccount) {break;}
					}
					if(!isDupAccount) {System.out.println("없는 계좌번호입니다."); continue;}
					/*Q.이건 true아니야? if(안이 true일때 실행 !boolean은 반대 즉 원래 false로 했으니까 이건 true
						continue를 선언하기 위해서 한 것. 만약 위에서 for문에 조건에 맞았다면 false가 true로 바뀌고
						!isDupAccount를 만났을때는 다시 false가 되니 실행 안하고 다음 문장을 실행하는 것 
					*/
					
					//비밀번호 비교
					System.out.println("비밀번호 : ");
					pw = sc.next();
					
					//복호화 후 pw 비교 
					if(Bank.decrypt(temp.pw).equals(pw)) {
						System.out.println("입금액 : ");
						money = sc.nextInt();
						
						if(money <1) {
							System.out.println("해당 금액은 입금하실 수 없습니다.");
							continue; //다시 입금액 받는 것 다시 while문으로 간다.
						}
						
						temp.deposit(money);
						System.out.println("입금 성공!");
					}else {
						System.out.println("잘못된 비밀번호입니다.");
					} 
					break;
					
					//출금하기
				case 3: 
					isDupAccount = false;
					System.out.println("계좌 번호 :");
					account = sc.next();
					
					for(int i=0; i<arMemberConunt.length; i++) {
						for(int j=0; j<arMemberConunt[i]; j++) {
							if(arrBank[i][j].account.equals(account)) {
								
								isDupAccount = true;
								temp = arrBank[i][j];
								break;
							}
						}
						if(isDupAccount) {break;}
						
					}
					if(!isDupAccount) {System.out.println("없는 계좌번호입니다."); continue;}
					
					System.out.println("비밀번호: ");
					pw = sc.next();
					
					
					if(Bank.decrypt(temp.pw).equals(pw)){
						System.out.println("출금액 :");
						money = sc.nextInt();
						
						if(money > 1) {
							System.out.println("해당금액은 출금하실 수 없습니다.");
							continue;
							
						}
						if(temp.withdraw(money)) { //withdraw는 boolean타입으로 선언되서 참이면 이게 실행
							System.out.println("출금성공!");
						}else { //withdraw가 false면 
							System.out.println("출금 실패 / 잔액부족");
						}
					}else {
						System.out.println("잘못된 비밀번호입니다.");
					}
					
					break;
					
					//잔액조회					
				case 4: 
					isDupAccount = false;
					
					System.out.println("계좌번호 :");
					account = sc.next();
					
					for(int i =0; i < arMemberConunt.length; i++ ) {
						for( int j =0; j< arMemberConunt[i]; j++) {
							if(arrBank[i][j].account.equals(account)){
								isDupAccount = true;
								temp = arrBank[i][j];
								break;
							}
							
						}if(isDupAccount) {break;}
					}
					if(!isDupAccount) {System.out.println("잘못된 계좌번호입니다."); continue;}
					
					System.out.println("비밀번호 :");
					pw = sc.next();
					if(Bank.decrypt(temp.pw).equals(pw)) {
						System.out.println("현재 잔액 :" + temp.getBanlace() + "원 ");
					}else {
						System.out.println("잘못된 비밀번호입니다.");
					}
					break;
					
					//계좌번호 찾기
				case 5: boolean isDuPhone =false ;
					System.out.println(" 핸드폰 번호( -제외 :");
					phone = sc.next();
					
					for(int i=0; i<arMemberConunt.length; i++) {
						for (int j =0; j< arMemberConunt[i]; j++) {
							if(arrBank[i][j].phone.equals(phone)) {
								isDuPhone =true;
								temp = arrBank[i][j] ; // 이사람의 번호와 같으니까 이사람을 찾아서 담았다.
								break;
							}
							if(isDuPhone) {break;}
						}
					}
						if(isDuPhone) {System.out.println("잘못된 핸드폰 번호입니다.");continue;}
						
						System.out.println("비밀번호 : ");
						pw = Bank.encrypt(sc.next());
						
						if(temp.pw.equals(pw)) {
							while(true) {
								isDupAccount =false;
								account = r.nextInt(900000) + 100000 + ""; //아직 값을 넘겨주진않았음
								
								for(int i =0; i<arMemberConunt.length; i++) {
									for(int j=0; j<arMemberConunt[i]; j++) {
										if(arrBank[i][j].account.equals(account)) {
											isDupAccount = true;
											break;
										}
									}if(isDupAccount) {break;}
								}
								if(!isDupAccount) {break;}
							}
							temp.account  = account; //여기서 기존의 account 값에 새로받은 account를 넣어준다.
							System.out.println("본인 인증이 완료되었습니다.");
							System.out.println(temp.name + "님의 새로운 계좌번호 :" + temp.account);
							
						}else 
							{System.out.println("잘못된 비밀번호입니다. ");
					}
				break;
				
				// 그외의 usermenu를 입력하면
				default: System.out.println("다시 시도해주세요");break;
					//계좌번호 찾기
				}//switch(user_choice)end
			}
		}//first while end
		
		
	}


}
