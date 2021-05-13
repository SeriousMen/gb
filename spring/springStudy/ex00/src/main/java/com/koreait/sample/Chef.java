package com.koreait.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

/*②*/
@Component //스프링에게 해당 클래스가 스프링에서 관리해야 하는 대상임을 표시 (모델 객체에 붙여줘야한다.) 부품이다. 스프링이 발견해서 객체화한다음 갈아껴준다(DI해준다.)
@Data //Lombok이 자동으로 getter/setter, 생성자, toString()을 만들어준다.
public class Chef {
	
	
}
