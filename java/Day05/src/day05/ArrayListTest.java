package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.UnaryOperator;

public class ArrayListTest {
	public static void main(String[] args) {
		//알고리즘 : 문제를 해결하기 위한 절차
		//자료구조 : 여러 알고리즘이 모여 구조화가 되어있는 것.
		//		의미없는 데이터가 자료구조를 통과하면 하나의 정보가 된다.
		//10: 의미 없는 값
		//int age =10; 자료구조 
		ArrayList<Integer> datas =new ArrayList<>();
		
//		datas.add(10);
		datas.add(80);
		datas.add(90);
		datas.add(50);
		datas.add(60);
		datas.add(70);
		datas.add(20);
		datas.add(30);
		 //cttl +alt 화살표 아래 복사해서 붙여넣기
		
		System.out.println(datas.size()); //컬렉션의 크기 
//		System.out.println(datas.get(7)); //인덱스니까 7 
		
		Collections.sort(datas);//Collections라는 클래스에 들어있는 sort메소드로 업캐스팅해서 정렬  
		System.out.println(datas); // 정렬된 값이 나온다. 
		
		
		
		//CRUD ( Create, Read, Update, Delete)
		
		/**
		 * 추가(40추가)
		 * 삽입(10뒤에 15삽입)
		 * 수정(20을 200으로 수정)
		 * 삭제(50 삭제)
		 */
		
		//추가(40추가)
		datas.add(40);
		
		//삽입(10뒤에 15삽입)
		System.out.println(datas.indexOf(10)); // ArrayList클래스의 indexOf()는 해당 값의 인덱스를 리턴  
		
		int idx =0;
		String msg = null;//일괄처리를 위해서 
		idx = datas.indexOf(10); //10이라는 값이 있는 인덱스가 담김 
		
		System.out.println(datas);
		if(datas.contains(10)) { // 10이라는 값이 없을 때 오류를 피하기 위해 -->만약 datas가 10이라는 값을 포함하고 있다면
		
		datas.add(idx+1, 15); // 해당 인덱스+1에 15을 추가로 삽입해라 
		msg= "삽입성공 : "+ datas.toString(); // toString()은 해당 객체가 가지고 있는 값을 리턴해준다. Collection에서 List안에 담긴 값을 리턴해주도록 오버라이딩함 
		}else {
			msg = "삽입 실패 : 값을 찾지 못했습니다.";
		}
		System.out.println(msg);
		
		
		
		
//		replaceAll 사용하는 법 
//		datas.replaceAll(new UnaryOperator<Integer>() {
//			
//			@Override
//			public Integer apply(Integer t) {
//				return 15;
//			}
//		});
		
		
		
		//수정
		
		idx =datas.indexOf(20);
		if(datas.contains(20)) {
			msg = datas.set(idx, 200)+"이 변경되었습니다. \n";
			msg += "수정성공: "+ datas.toString();
		}else {
			msg = "수정 실패 : 찾는 값이 없습니다.";
		}
		System.out.println(msg);
//		System.out.println(datas.indexOf(20));
		
		
		//삭제
//		System.out.println(datas.indexOf(50));
//
//		datas.remove(4);
//		Collections.sort(datas);
//		System.out.println(datas);
		
		if(datas.remove(new Integer(50))){ // remove()는 매개 변수를 Object타입으로 받기 떄문에 Integer의 생성자에 지울 값을 넣는다.
			msg ="삭제성공"+ datas.toString();
		}else {
			msg = "삭제 실패";
		}
		System.out.println(msg);
		
		/////////////////////////////////////////////////////
		ArrayList<Integer> datas2 = new ArrayList<>();
		
		datas2.add(10);
		datas2.add(10);
		datas2.add(20);
		datas2.add(10);
		System.out.println(datas2);
		
		//마지막 10을 삭제한다. 
//		System.out.println(datas2.lastIndexOf(10));
		
		//두번째 10을 삭제한다.
		//1.정렬 후 10을 찾고 + 1번쨰 인덱스
		//2.정렬하지 않고 //순서가 있는 걸 iterator라고한다.
		/*값만 필요할 떄
		for( int data: datas2) { //int data는 integer를 오토언박싱
			
		}
		*/
		
		
		//인덱스도 필요할 떄
//		int cnt = 0;
//		for(int i = datas.indexOf(10); i < datas2.size(); i+=datas.indexOf(10)) {
//			if(datas.get(i) == 10) { 
//				cnt++; 
//				datas2.remove(i);
//			}
//		}
		
		//두번째 10을 삭제한다.
		//찾는 값이 여러 개 있을 때 각 값의 인덱스 번호를 저장할 List
		ArrayList<Integer> idxs = new ArrayList<>();
		
		for(int i = 0; i <datas2.size(); i++) { //datas2의 크기만큼 반복
			//10이라는 값일 때 idxs에 인덱스 번호를 저장
			if(datas2.get(i) ==10) { //만약 i번째 방의 값이 10 이라면 그 인덱스를 idxs 값으로  추가해라  
				idxs.add(i);
			}
		}
		System.out.println(idxs); //-> 10이 값인 방들의 인덱스를 다 출력
		
		try {//위에서 idx를 Integer타입으로 해서 박싱이 된 상태(객체화) 그래서 int타입으로 풀어줘야된다 왜? remove(int 인덱스)니까 
			//remove(int idx)를 사용하기 위해서는 Integer를 int로 unboxing 해야한다. int idx 는 인덱스 번호 
			//따라서 idxs.get(1).intValue()를 통해 int 타입으로 Unboxing해주면,
			//remove(int idx)로 인식되어 해당 인덱스에 있는 값이 삭제된다.
			datas2.remove(idxs.get(1).intValue()); //이경우는 두번째 값을 지워야하니 idx의 1인덱스에 있는 값(datas의10이있는 인덱스)를 리턴해도 int타입으로 
			//datas2.remove(idxs.get(1)); 이렇게하면 오류는 안나는데 값이 반영이안됨 int 타입이아니라 integer타입의 객체라서 
			System.out.println(datas2);
		} catch (Exception e) {
			//잘못된 인덱스 전달 시 
			System.out.println("존재하지않는 인덱스입니다.");
		} 
		
		
	}
}
