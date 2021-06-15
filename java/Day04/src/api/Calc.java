package api;

//import api2.Math2;

/**
 * 
 * @author 조창현
 * @sincs JDK8
 * <br>Calculator 
 */
public class Calc {
	//<br>은 어노테이션에서 줄바꿈 
	
	/**
	 * To div the following numbers. <br>
	 * For example<br>
	 * <code>div(10,3) : 3 </code>
	 * @param num1
	 * @param num2
	 * @return : int
	 * 
	 * @see Math
	 * @throws ArithmeticException
	 * 
	 */
	public int div(int num1, int num2) {
		
		return num1/num2;
		
	}
	
//	public static void main(String[] args) {
//		Math2 m = new Math2(); // 외부 api 사용 가능 
//		
//	}
}
