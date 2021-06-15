package day03;

public class Access1 {
	int data1 = 10; //default
	
	public int data2 = 11; //public
	protected int data3 =12; // protected
	private int data4 =13;	// private (반드시 getter()와 setter()를 만들라는 경고)
	
	
	public Access1() {
	}
	
	// 데이터를 입출력 할 때  1. 명시적 생성자 2. 게터세터 
public Access1(int data4) {
	this.data4 = data4;

}
	
	//게터 세터 생성 단축키 : alt +shift +s , r , 객체 선택 후 , alt+r
	public int getData4() {
		return data4;
	}
	public void setData4(int data4) {
		this.data4 = data4;
	}

	
}

