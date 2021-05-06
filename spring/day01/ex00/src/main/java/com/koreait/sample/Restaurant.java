package com.koreait.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

/*②*/
@Component	//모델 객체에만 Component를 쓴다.
@Data
public class Restaurant {
	//Chef에 의존하는 Restaurant를 만들자
	
//private Chef chef = new Chef(); 이렇게 안하게 하려고 의존성 주입을 한다.
	
	/**
	 * onMethod 속성은 생성되는 setChef에 @Autowired 어노테이션을 추가하도록 할 때 사용된다.
	 * 버전에 따라 onMethod 혹은 onMethod_를 사용하게 된다.
	 */
	/*③*/
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
}
