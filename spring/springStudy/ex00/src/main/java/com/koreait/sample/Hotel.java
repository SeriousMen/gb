package com.koreait.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component 
@Getter	//@Data말고 이렇게 하나하나 지정해서 불러올 수 있다.
@ToString

//@AllArgsConstructor // 여기있는 모든 필드를 초기화할 생성자를 만들겠다.
@RequiredArgsConstructor //(생성자)내가 필요한 것만 초기화(특정 변수에 대해서만 생성자를 작성할 때 작성한다.
//@NonNull이나 final이 붙은 인스턴스 변수에 대한 생성자를 만들어 낸다.
public class Hotel {
	
	@NonNull
	private Chef chef;
	

}
