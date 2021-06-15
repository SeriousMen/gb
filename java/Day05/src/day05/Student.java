package day05;

public class Student {
	int  num;
	String name;
	
	public Student() {;}

	public Student(int num, String name) {
		
		this.num = num;
		this.name = name;
	}
	
	
	@Override
	public boolean equals(Object obj) {	//Map에 담을 거라서 equals를 재정의해준다. 원래 Object의 equals()는 두 객체의 해쉬코드로 비교 
		if(obj instanceof Student) {
			Student std = (Student)obj; // 입력받은 객체를 Student 타입으로 다운캐스팅 
			if(std.num == this.num) { // 만약 입력받은 num이 기존의 num과같다면 true를 리턴 
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {// 마찬가지로 해쉬코드도 재정의해준다. 
		
		return this.num;
	}
}
