package day05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String,Integer>fruitMap = new HashMap<>();
		int total = 0;
		fruitMap.put("사과", 3500);
		fruitMap.put("배", 4000);
		fruitMap.put("자두", 1500);
		fruitMap.put("수박", 8000);
		
		System.out.println(fruitMap); // Set은 다 { } 안에 값이 나오는 듯? to String으로 순서 정렬
		System.out.println(fruitMap.get("수박")); //키 값을 입력하면 벨류를 리턴
		
		//키값 가져와서 출력 iterator()의 내용은 알 수 없으나. 이런 방식으로 담아져 있는 값들을 반환한다.
		Iterator<String> fruitNames = fruitMap.keySet().iterator(); // 리턴이 String인 객체를 담는다. 
		
		while(fruitNames.hasNext()) {//그리고 값이 다 없어질때까지 
			System.out.println(fruitNames.next());//담아져있는 값들을 출려개할 
		}
		
		//value 분리 : value()
		//과일 평균가격 출력
//		int a =fruitMap.size();
//		int sum=0;
//		for(int i; i<fruitMap.size(); i++ ) {
//		 fruitMap.values();
//		}
////		int b  fruitMap.values();
//		System.out.println(fruitMap.values());
		System.out.println("============과일 평균가격 출력하기===================");
		//과일 평균 가격 출력 선생님ver
		//value분리 values()
		fruitMap.values().forEach(price->{ //forEach에서 price라는 Integer 타입 변수를 선언하고 그변수에 값들을 다담는다. 그리고나서 price를 출력한다.
			//다른 영역의 변수에 연산을 할 수 없다. 
			System.out.println(price);
		});
		for(Integer value : fruitMap.values()) { //향상된 for문에서 value라는 Integer타입 변수를 선언한다. 그리고 값을 담는다.
			total += value; // total이라는 변수에  벨류의 총합을 담는다.
		}
		
		double avg = Double.parseDouble( //더블 타입의 avg라는 변수를 선언하고 
		String.format("%.2f",(double)total/fruitMap.size()));//total/4한 값을 소숫점 자리 2개까지 나오게 한 값을 Double형으로 avg에 담는다.
		
		System.out.println("과일평균:" +avg +"원"); //Q.왜 과일평균이 4250.00이 아닌 4250.0이 나오는 지 모르겠다.0이라서?
		
		
		System.out.println("============테스트==========");
		double temp = 4250.22222;
		double t = Double.parseDouble(String.format("%.2f", (double)temp));//이거보면 0이아니면 출력이되네 
		System.out.println("test소숫점아래가 0이 아닐떄:" +t);
		
		
		//메뉴판
		//한 쌍씩 분리(entrySet())
		Iterator<Entry<String, Integer>> iter = fruitMap.entrySet().iterator(); // 키와 벨류를 iter에 다담는다.
		
		while(iter.hasNext()) {// iter가 값이 있는 동안 entry에 담고 
			Entry<String,Integer> entry = iter.next(); //이렇게 출력하면 메뉴 출력
			System.out.println(entry.getKey()+ ": "+ entry.getValue() + "원");
		}
	}
}
