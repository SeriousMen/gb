package obj;
// 객체를 비교할 때 equals와 hashcode를 직접 재정의하는 법
public class Student { //alt + shift a : 그리드 모드 커서를 확대해서 한번에 일괄적으로 원하는 코드를 작성해줄 수 있음
public int num;
public String name;
 
public Student() {
	// TODO Auto-generated constructor stub
}

public Student(int num, String name) {
	super();
	this.num = num;
	this.name = name;

}
@Override // 반드시 equals를 재정의할때는 hashcode를 재정의해줘야한다. 왜? 컬렉션프레임워크에서 set은 중복이안되고 hashCode로비교한다. 
	public boolean equals(Object obj) { // equals에서 num이 서로 같으면 동등한걸로 보겠다. 라고 정의 
		if(obj instanceof Student) {
			Student std = (Student) obj;
			if(this.num == std.num) { //만약 Student 클래스에있는 num과 입력받은 num 이 같다면 true
				return true;
			}
		}
		return false;
	}

@Override
	public int hashCode() {

		return this.num; // 해시코드를 num이 같으면 같은거로 보겠다라고 재정의
	}
}
