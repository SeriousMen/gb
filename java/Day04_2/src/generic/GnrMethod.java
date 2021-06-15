package generic;
//제네릭 메소드
public class GnrMethod {
	public static <T> T function(T data) { //제네릭 메소드는 리턴타입앞에 <타입> 제네릭을 선언해준다. 이건 리턴타입도 제네릭으로해주고 매개 변수타입도 제네릭한듯? 
		//static했을떄 컴파일이 올린다. 
		
		T result = null;
		
		if(data instanceof Integer) { //아직 정해지지 않았지만 입력받은 data가 인티저타입이라면 result는 정수
			result = (T)"정수";
			
		}else if(data instanceof Double || data instanceof Float) {
			result =(T)"실수";	//아직 정해지지 않았지만 입력받은 data가 실수타입이라면 result는 실수
			
		}else if(data instanceof Character) {
			result = (T)"문자";
		}else if(data instanceof String) {
			result = (T)"문자열";
		}
		return result;
	}
}
