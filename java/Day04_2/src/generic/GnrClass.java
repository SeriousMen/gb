package generic;

public class GnrClass<T> { //이렇게 클래스에서 사용할 타입을 제네릭으로 
	
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

}
