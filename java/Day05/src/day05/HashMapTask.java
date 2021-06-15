package day05;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTask {

	public static void main(String[] args) {
			HashMap<Student,ArrayList<Integer>> gradeMap = new HashMap<>();
			//gradeMap이라는 해쉬맵은 키값으로 Student 객체를 벨류로 인티저타입의 어레이리스트로
			ArrayList<Integer>scoreList = new ArrayList<>();
		
			scoreList.add(80); //국어
			scoreList.add(30); //영어
			scoreList.add(50); //수학
			//이렇게 되면 Student에는 학생번호와 이름이 있기 떄문에 학생이름과 번호로 해당 점수를 찾는다. 
		
			gradeMap.put(new Student(1,"한동석"), scoreList);
			//해쉬맵은 put으로 키값에 따른 벨류를 넣는다. 1,"한동석" 하면 국어 영어 수학 점수가 나온다. 
//			System.out.println(gradeMap.get(1,"한동석")); //키 값의 타입을 위에서 Student라는 객체로 선언했기때문에 Student라는 객체를 넣어야함
			
			System.out.println(gradeMap.get(new Student(1, "한동석")));
			//새로운 객체를 형성해서 생성자에 1, "한동석"으로 초기화했으므로 다른 주소에 값을 넣은거지만
			// equals() 와 hashCode()를 오버라이딩했기떄문에 같은 객체로 인식한다. 
			
		
		}
}
