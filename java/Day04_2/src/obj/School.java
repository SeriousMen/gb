package obj;

import java.util.HashSet;
import java.util.Set;

public class School {
	public static void main(String[] args) {
		
		
		Student 한동석 = new Student(1,"한동석"); // 한동석이라는 Student타입의 객체를 생성하고 값을 할당해줌
		Set<Student> stdSet = new HashSet< >(); // Student 타입의 자료를 저장하는 HashSet을 생성해줌 
		
		stdSet.add(한동석);//1,과"한동석"이 들어감 
		stdSet.add(new Student(1, "한동석"));//위하고 똑같은 값을 가진 새로운 객체를 생성해줌 
		
		System.out.println(stdSet.size());//Student 클래스에서 hashCode를 재정의해서 같은 해시코드
		
		
		System.out.println(한동석.equals(new Student(1,"한동석"))); //Student 클래스에서 equals를 재정의해서 true
		
	}
}
