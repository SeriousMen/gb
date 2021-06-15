package day05;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		//spring framework를 위해 카멜표기법으로만 작성한다. _말고
		HashSet<String>bloodTypeSet = new HashSet<>();
		
		bloodTypeSet.add("A");
		bloodTypeSet.add("B");
		bloodTypeSet.add("O");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		System.out.println(bloodTypeSet.size());
		System.out.println(bloodTypeSet.toString()); // 출력할떄 뒤에 .toString()생략되있는것  
													//toString()에서 기본적으로 출력될떄 순서를 오름차순으로 정돈해준다.
													// toString()은 생략되있는 것이다. default임 
		Iterator<String> iter = bloodTypeSet.iterator();	//Set의 핵심 Iterator
		while(iter.hasNext()){ // 몇개들엇는지 알 수없으니 for문말고 while문으로 
			System.out.println(iter.next()+"형");//Set은 중복이안되서 중복된 값들은 다 안들어간다.
		}
		System.out.println(bloodTypeSet.contains("AB")); //혈액형이 있는지 없는지 
	}
}
