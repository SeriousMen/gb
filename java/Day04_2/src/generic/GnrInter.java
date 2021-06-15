package generic;

public interface GnrInter<N1,N2> {//이렇게 인터페이스에서 메소드에서 사용할 타입을 제네릭으로 
	N1 add(N1 data1, N2 data2);
	N1 sub(N1 data1, N2 data2);
	N2 mul(N2 data, N2 data2);

}


