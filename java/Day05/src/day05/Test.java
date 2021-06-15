package day05;

public class Test {

	public static void changeData2(int data) {
		data = 100; 
	}
	public static void changeData(int[] data) {
		data[0] = 100;
	}
	
	//주소를 사용하는 이유
	//1. 여러개의 값을 리턴하고 싶을 떄
	//2.다른지역에 있는 저장공간의 값을 변경하고 싶을 떄 
	public static void main(String[] args) {
		int data2 = 10;
		Test.changeData2(data2);//이건 그냥 10이라는 값을 넘겨준것. 
		System.out.println(data2); // 그래서 그냥 10이 나온다. 
		
		int [] data = {10}; // data라는 배열에 0번인덱스에 10을 대입했다.
		Test.changeData(data);// 위의 메소드에가서 data의 주소를 넘겨준다. 그러면 메소드에 의해 data[0]에 100을 넣어준다. 
		System.out.println(data); // 이 data라는 것은 방 주소를 말한다.
		System.out.println(data[0]);
		
	}
}
