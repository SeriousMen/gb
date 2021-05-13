package com.koreait.domain; //도메인 모델이란 VO DTO같은 객체를 말하는듯?

import lombok.Data;

//import org.springframework.stereotype.Component;

//@Component 컨트롤러의 메소드안에 매개변수로 모델객체를 쓴다면 컴포넌트로 모델객체를 연결할 필요가 없다(매핑하면서 불러오니까)

@Data //롬복을 통해 게터,세터,투스트링,equals,hashCode @Data
public class SampleDTO { //SampleDTO라는 객체를 생성 후 
	private String name;
	private int age;
	
}
